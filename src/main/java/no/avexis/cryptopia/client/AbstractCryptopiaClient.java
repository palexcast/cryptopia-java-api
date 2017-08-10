package no.avexis.cryptopia.client;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public abstract class AbstractCryptopiaClient {
    private static final String API_URL = "https://www.cryptopia.co.nz/api/";

    JsonObject getJsonResponse(final CloseableHttpResponse response) throws IOException {
        final String json = EntityUtils.toString(response.getEntity());
        return new JsonParser().parse(json).getAsJsonObject();
    }

    String getApiUrl() {
        return API_URL;
    }
}
