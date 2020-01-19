package org.openchat.common.exceptions;

public class FourHundredException extends RuntimeException {
    protected static final long serialVersionUID = 1L;
    private final int httpStatus;

    public FourHundredException(int httpStatus, String message) {
        super(message);
        this.httpStatus = httpStatus;
    }

    public int getHttpStatus() {
        return this.httpStatus;
    }
}
