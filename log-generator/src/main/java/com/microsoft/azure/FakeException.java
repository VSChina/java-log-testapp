package com.microsoft.azure;

public class FakeException extends RuntimeException{
    public FakeException() {
        super();
    }

    public FakeException(String s) {
        super(s);
    }

    public FakeException(String message, Throwable cause) {
        super(message, cause);
    }
}
