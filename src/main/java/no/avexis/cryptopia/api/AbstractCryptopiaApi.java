package no.avexis.cryptopia.api;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import javafx.util.Pair;
import no.avexis.cryptopia.exceptions.MissingParameterException;

abstract class AbstractCryptopiaApi {

    static final Gson gson = new Gson();

    JsonElement getData(final JsonObject jsonObject) {
        return jsonObject.get("Data");
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

    <T> T req(final T param) throws MissingParameterException {
        if (null == param) {
            throw new MissingParameterException("A required field is missing");
        }
        return param;
    }

    <T> T[] req(final T[] param) throws MissingParameterException {
        if (null == param || param.length < 1 || null == param[0]) {
            throw new MissingParameterException("Array field is required and missing");
        }
        return param;
    }

    String arrayAsString(final String[] arr) {
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
}
