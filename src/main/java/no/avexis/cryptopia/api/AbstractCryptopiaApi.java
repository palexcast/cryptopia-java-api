package no.avexis.cryptopia.api;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import javafx.util.Pair;
import no.avexis.cryptopia.exceptions.MissingParameterException;

import java.lang.reflect.Type;
import java.util.List;

abstract class AbstractCryptopiaApi {

    private static final String PARAM_IS_REQUIRED = "Param \"%s\" is required";
    private static final Gson gson = new Gson();

    JsonElement getData(final JsonObject jsonObject) {
        return jsonObject.get("Data");
    }

    <T> T fromJson(final JsonElement element, final Type type) {
        return gson.fromJson(element, type);
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
            throw new MissingParameterException(String.format(PARAM_IS_REQUIRED, param.getKey()));
        }
    }


    void req(final String name, final Object value) throws MissingParameterException {
        if (null == value) {
            throw new MissingParameterException(String.format(PARAM_IS_REQUIRED, name));
        }
    }

    void reqArray(final String name, final Object[] param) throws MissingParameterException {
        if (null == param || param.length == 0) {
            throw new MissingParameterException(String.format(PARAM_IS_REQUIRED, name));
        }
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

    JsonObject toJsonObject(final List<Pair<String, Object>> pairs) {
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
