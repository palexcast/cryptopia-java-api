package no.avexis.cryptopia.client;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import no.avexis.cryptopia.exceptions.CryptopiaException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public abstract class AbstractCryptopiaClient {
    private static final String API_URL = "https://www.cryptopia.co.nz/api/";

    JsonObject getJsonResponse(final CloseableHttpResponse response) throws CryptopiaException {
        final String json;
        try {
            json = EntityUtils.toString(response.getEntity());
        } catch (final IOException e) {
            throw new CryptopiaException("Could not parse response", e);
        }
        return new JsonParser().parse(json).getAsJsonObject();
    }

    String getApiUrl() {
        return API_URL;
    }
}
