package no.avexis.cryptopia.api;

import javafx.util.Pair;
import no.avexis.cryptopia.exceptions.MissingParameterException;
import no.avexis.cryptopia.utils.StringUtils;

abstract class AbstractCryptopiaApi {

    private static final String PARAM_IS_REQUIRED = "Param \"%s\" is required";

    String addUrlParams(final String method, Object... params) {
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
        } else if (StringUtils.isBlank(param.getKey())) {
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

    void either(final Pair<String, Object> pair1, final Pair<String, Object> pair2) throws MissingParameterException {
        if (null == pair1 || null == pair2) {
            throw new NullPointerException("Pairs in 'either(..)' can not be null, only their values");
        }
        boolean pair1IsNull = null == pair1.getValue();
        boolean pair2IsNull = null == pair2.getValue();
        if (pair1IsNull && pair2IsNull) {
            throw new MissingParameterException(String.format("Either \"%s\" or \"%s\" is required", pair1.getKey(), pair2.getKey()));
        }
    }

    void reqIfIs(final Object reqObj, final Object ifObj, final Object isObj) throws MissingParameterException {
        if (ifObj.equals(isObj) && null == reqObj) {
            throw new MissingParameterException("A required field is missing");
        }
    }
}
