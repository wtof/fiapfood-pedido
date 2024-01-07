package br.com.fiapfood.pedido.application.exceptions;

public class ApplicationException extends RuntimeException {
    private static final long serialVersionUID = 4260483373395023237L;

    public ApplicationException() {
    }

    public ApplicationException(String message) {
        super(message);
    }

    public ApplicationException(String message, Throwable cause) {
        super(message, cause);
    }

    public ApplicationException(Throwable cause) {
        super(cause);
    }
}
