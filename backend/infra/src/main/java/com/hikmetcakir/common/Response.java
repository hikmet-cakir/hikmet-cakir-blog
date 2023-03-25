package com.hikmetcakir.common;

public class Response<T> {

    private T data;
    private ErrorResponse errors;
    private SuccessResponse success;

    public Response() {
    }

    public Response(ErrorResponse errors) {
        this.errors = errors;
    }

    public Response(SuccessResponse success) {
        this.success = success;
    }

    public Response(T data) {
        this.data = data;
    }

    public ErrorResponse getErrors() {
        return errors;
    }

    public SuccessResponse getSuccess() {
        return success;
    }

    public T getData() {
        return data;
    }
}
