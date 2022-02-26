package com.work1.JavaBoot_WorkI.response;

public class ErrorMessageResponse {
    private String errorCode;
    private String errorMessage;

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public ErrorMessageResponse() {
    }

    public ErrorMessageResponse(String errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public ErrorMessageResponse(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
