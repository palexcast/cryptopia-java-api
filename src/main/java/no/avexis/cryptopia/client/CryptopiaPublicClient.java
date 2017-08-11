package no.avexis.cryptopia.client;


import com.google.gson.JsonObject;
import no.avexis.cryptopia.exceptions.CryptopiaException;
import no.avexis.cryptopia.exceptions.UnexceptedResponseException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;

public class CryptopiaPublicClient extends AbstractCryptopiaClient {


    public JsonObject send(final String method) throws CryptopiaException {
        try (final CloseableHttpClient httpclient = HttpClients.createDefault()) {
            final HttpGet request = new HttpGet(getApiUrl() + method);
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
}
