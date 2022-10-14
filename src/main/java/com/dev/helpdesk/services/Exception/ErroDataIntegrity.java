package com.dev.helpdesk.services.Exception;

public class ErroDataIntegrity extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public ErroDataIntegrity(String message) {
        super(message);
    }
    public ErroDataIntegrity(String message, Throwable cause) {
        super(message, cause);
    }
}
