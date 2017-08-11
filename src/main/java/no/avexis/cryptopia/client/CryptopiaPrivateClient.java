package no.avexis.cryptopia.client;


import com.google.gson.JsonObject;
import no.avexis.cryptopia.exceptions.CryptopiaException;
import no.avexis.cryptopia.exceptions.UnexceptedResponseException;
import no.avexis.cryptopia.utils.CryptopiaAuthUtils;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class CryptopiaPrivateClient extends AbstractCryptopiaClient {

    private final String publicKey;
    private final String privateKey;

    public CryptopiaPrivateClient(final String publicKey, final String privateKey) {
        this.publicKey = publicKey;
        this.privateKey = privateKey;
    }


    public JsonObject send(final String method, final JsonObject params) throws CryptopiaException {
        try (final CloseableHttpClient httpclient = HttpClients.createDefault()) {
            final HttpPost request = buildRequest(method, params);
            try (final CloseableHttpResponse response = httpclient.execute(request)) {
                final int responseCode = response.getStatusLine().getStatusCode();
                if (200 != responseCode) {
                    throw new UnexceptedResponseException(responseCode, response.getStatusLine().getReasonPhrase());
                }
                return getJsonResponse(response);
            }
        } catch (final IOException e) {
            throw new CryptopiaException("Failed to build/send request", e);
        }
    }

    private HttpPost buildRequest(final String method, final JsonObject params) throws CryptopiaException {
        final HttpPost request = new HttpPost(getApiUrl() + method);
        String jsonParams = "{}";
        if (null != params) {
            jsonParams = params.toString();
        }
        StringEntity entity;
        try {
            entity = new StringEntity(jsonParams);
        } catch (UnsupportedEncodingException e) {
            throw new CryptopiaException("Could not could request entity", e);
        }
        request.setEntity(entity);
        try {
            request.setHeader("Authorization", CryptopiaAuthUtils.createAuth(publicKey, privateKey, getApiUrl() + method, jsonParams));
        } catch (final UnsupportedEncodingException | InvalidKeyException | NoSuchAlgorithmException e) {
            throw new CryptopiaException("Could not build Authorization header", e);
        }
        request.setHeader("Content-Type", "application/json");
        return request;
    }
}
