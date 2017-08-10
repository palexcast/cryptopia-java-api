package no.avexis.cryptopia.utils;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public final class CryptopiaAuthUtils {

    private CryptopiaAuthUtils() {
        throw new IllegalAccessError("Utlity class");
    }

    private static String urlEncodeMethod(final String urlMethod) throws UnsupportedEncodingException {
        return URLEncoder.encode(urlMethod, StandardCharsets.UTF_8.toString()).toLowerCase();
    }

    private static String reqSignature(final String publicKey, final String urlMethod, final String jsonPostParm, final String nonce) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        return publicKey + "POST" + urlEncodeMethod(urlMethod) + nonce + getMD5Base64(jsonPostParm);
    }

    private static String auth(final String publicKey, final String privateKey, final String urlMethod, final String jsonPostParm, final String nonce) throws UnsupportedEncodingException, NoSuchAlgorithmException, InvalidKeyException {
        return "amx " + publicKey + ":" + sha256Base64(privateKey, reqSignature(publicKey, urlMethod, jsonPostParm, nonce)) + ":" + nonce;
    }

    private static String getMD5Base64(final String postParameter) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        return Base64.getEncoder().encodeToString(MessageDigest.getInstance("MD5").digest(postParameter.getBytes("UTF-8")));
    }

    private static String sha256Base64(final String privateKey, final String msg) throws NoSuchAlgorithmException, InvalidKeyException, UnsupportedEncodingException {
        final Mac sha256HMAC = Mac.getInstance("HmacSHA256");
        final SecretKeySpec secretKey = new SecretKeySpec(Base64.getDecoder().decode(privateKey), "HmacSHA256");
        sha256HMAC.init(secretKey);
        return Base64.getEncoder().encodeToString(sha256HMAC.doFinal(msg.getBytes("UTF-8")));
    }

    public static String createAuth(final String publicKey, final String privateKey, final String urlMethod, final String jsonPostParm)
            throws UnsupportedEncodingException, InvalidKeyException, NoSuchAlgorithmException {
        String nonce = String.valueOf(System.currentTimeMillis());
        return auth(publicKey, privateKey, urlMethod, jsonPostParm, nonce);
    }
}
