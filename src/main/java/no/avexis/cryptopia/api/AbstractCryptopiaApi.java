package no.avexis.cryptopia.api;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import javafx.util.Pair;
import no.avexis.cryptopia.exceptions.MissingParameterException;
import no.avexis.cryptopia.models.pub.Currency;

import java.lang.reflect.Type;
import java.util.ArrayList;

abstract class AbstractCryptopiaApi {

    static final Gson gson = new Gson();

    JsonElement getData(final JsonObject jsonObject) {
        return jsonObject.get("Data");
    }

    <T> T fromJson(final JsonElement element) {
        final Type listType = new TypeToken<T>() {
        }.getType();
        return gson.fromJson(element, listType);
    }

    String addParams(final String method, Object... params) {
        final StringBuilder sb = new StringBuilder(method);
        for (final Object param : params) {
            if (null != param) {
                sb.append("/");
                sb.append(param);
            }
        }
        return sb.toString();
    }

    <T> void req(final Pair<String, T> param) throws MissingParameterException {
        if (null == param) {
            throw new NullPointerException("Param can not be null");
        } else if (isBlank(param.getKey())) {
            throw new MissingParameterException("Param key is missing");
        } else if (null == param.getValue()) {
            throw new MissingParameterException("Param \"" + param.getKey() + "\" is required");
        }
    }


    <T> void req(final String name, final Object value) throws MissingParameterException {
        if (null == value) {
            throw new MissingParameterException("Param \"" + name + "\" is required");
        }
    }

    <T> T[] reqArray(final String name, final T[] param) throws MissingParameterException {
        if (null == param || param.length < 1 || null == param[0]) {
            throw new MissingParameterException("Param \"" + name + "\" is required");
        }
        return param;
    }

    String arrayAsString(final String[] arr) {
        if (null == arr || 0 == arr.length) {
            return "";
        }
        final StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length - 1; i++) {
            sb.append(arr[i]);
            sb.append("-");
        }
        sb.append(arr[arr.length - 1]);
        return sb.toString();
    }

    JsonObject toJsonObject(final Pair<String, Object>... pairs) {
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

    void either(final Object obj1, final Object obj2) throws MissingParameterException {
        if (null == obj1 && null == obj2) {
            throw new MissingParameterException("Atleast one field is required");
        }
    }

    void reqIfIs(final Object reqObj, final Object ifObj, final Object isObj) throws MissingParameterException {
        if (ifObj.equals(isObj) && null == reqObj) {
            throw new MissingParameterException("A required field is missing");
        }
    }

    private boolean isBlank(final String str) {
        return null == str || str.trim().length() == 0;
    }
}
