package com.edev.emall.order.exception;

public class RemoteCallException extends RuntimeException {
    public RemoteCallException() {
        super();
    }

    public RemoteCallException(String message, Throwable ex) {
        super(message, ex);
    }

    public RemoteCallException(String message, Object...args) {
        super(String.format(message, args));
    }

    public RemoteCallException(String message, Throwable ex, Object...args) {
        super(String.format(message, args), ex);
    }
}
