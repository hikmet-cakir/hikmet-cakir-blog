package com.hikmetcakir.common;

public class SuccessResponse {

    private String successCode;
    private String successDescription;

    public SuccessResponse() {
    }

    public SuccessResponse(String successCode, String successDescription) {
        this.successCode = successCode;
        this.successDescription = successDescription;
    }

    public String getSuccessCode() {
        return successCode;
    }

    public String getSuccessDescription() {
        return successDescription;
    }
}
