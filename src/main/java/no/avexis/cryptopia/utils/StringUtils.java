package no.avexis.cryptopia.utils;

public final class StringUtils {
    private StringUtils() {
        throw new IllegalAccessError("Utlity class");
    }

    public static String arrayAsString(final String[] arr) {
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

    public static boolean isBlank(final String str) {
        return null == str || str.trim().length() == 0;
    }
}
