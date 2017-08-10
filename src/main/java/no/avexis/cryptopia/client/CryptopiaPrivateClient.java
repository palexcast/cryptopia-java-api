package no.avexis.cryptopia.client;


import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import no.avexis.cryptopia.utils.CryptopiaAuthUtils;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.client.LaxRedirectStrategy;

import javax.net.ssl.HttpsURLConnection;
import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class CryptopiaPrivateClient extends AbstractCryptopiaClient {

    private final String publicKey;
    private final String privateKey;

    public CryptopiaPrivateClient(final String publicKey, final String privateKey) {
        this.publicKey = publicKey;
        this.privateKey = privateKey;
    }


    public JsonObject send(final String method, final JsonObject params) throws Exception {
        try (final CloseableHttpClient httpclient = HttpClients.createDefault()) {
            final HttpPost request = buildRequest(method, params);
            try (final CloseableHttpResponse response = httpclient.execute(request)) {
                final int responseCode = response.getStatusLine().getStatusCode();
                if (200 != responseCode) {
                    throw new Exception("Unexpected response: " + responseCode + ":" + response.getStatusLine().getReasonPhrase());
                }
                return getJsonResponse(response);
            }
        }
    }

    private HttpPost buildRequest(final String method, final JsonObject params) throws UnsupportedEncodingException, InvalidKeyException, NoSuchAlgorithmException {
        final HttpPost request = new HttpPost(getApiUrl() + method);
        String jsonParams = "{}";
        if (null != params) {
            jsonParams = params.toString();
        }
        StringEntity entity = new StringEntity(jsonParams);
        request.setEntity(entity);
        request.setHeader("Authorization", CryptopiaAuthUtils.createAuth(publicKey, privateKey, getApiUrl() + method, jsonParams));
        request.setHeader("Content-Type", "application/json");
        return request;
    }
}
