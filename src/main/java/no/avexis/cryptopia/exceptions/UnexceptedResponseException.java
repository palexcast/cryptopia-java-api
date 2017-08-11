package no.avexis.cryptopia.exceptions;

public class UnexceptedResponseException extends CryptopiaException {
    public UnexceptedResponseException(final Integer code, final String reason) {
        super("Unexpected response: " + code + ":" + reason);
    }
}
