package com.dkk.rxjava.samplerxjava.models;

/**
 * Created by deepak on 27/2/17.
 */

public class ErrorModel extends Exception {
    private final Throwable throwabale;
    private int erroCode;
    private int statusCode;
    private Exception exception;
    private String errorMessage;

    public ErrorModel(Throwable t) {
        this.throwabale = t;
    }

    public int getErroCode() {
        return erroCode;
    }

    public void setErroCode(int erroCode) {
        this.erroCode = erroCode;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public Exception getException() {
        return exception;
    }

    public void setException(Exception exception) {
        this.exception = exception;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public Throwable getThrowabale() {
        return throwabale;
    }
}
