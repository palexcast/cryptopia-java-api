package no.avexis.cryptopia.utils;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import javafx.util.Pair;

import java.lang.reflect.Type;
import java.util.List;

public final class JsonUtils {
    private JsonUtils() {
        throw new IllegalAccessError("Utlity class");
    }

    private static final Gson gson = new Gson();

    public static JsonObject toJsonObject(final List<Pair<String, Object>> pairs) {
        JsonObject result = new JsonObject();
        boolean containsParams = false;
        for (final Pair<String, Object> p : pairs) {
            if (null != p.getKey() && null != p.getValue()) {
                result.addProperty(p.getKey(), p.getValue().toString());
                containsParams = true;
            }
        }
        if (containsParams) {
            return result;
        }
        return null;
    }

    public static JsonElement getData(final JsonObject jsonObject) {
        return jsonObject.get("Data");
    }

    public static <T> T fromJson(final JsonElement element, final Type type) {
        return gson.fromJson(element, type);
    }

    public static <T> T fromJson(final JsonElement element, final Class<T> cls) {
        return gson.fromJson(element, cls);
    }
}
