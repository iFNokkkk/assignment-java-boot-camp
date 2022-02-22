package com.work1.JavaBoot_WorkI.response;

public class UserResposnse {

    private String loginMessage;

    public UserResposnse() {
    }

    public UserResposnse(String loginMessage) {
        this.loginMessage = loginMessage;
    }

    public String getLoginMessage() {
        return loginMessage;
    }

    public void setLoginMessage(String loginMessage) {
        this.loginMessage = loginMessage;
    }
}
