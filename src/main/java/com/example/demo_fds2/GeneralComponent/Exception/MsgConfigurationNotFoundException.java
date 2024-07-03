package com.example.demo_fds2.GeneralComponent.Exception;

public class MsgConfigurationNotFoundException extends Exception {
    public MsgConfigurationNotFoundException() {
        super("Msg Configuration not found, please input correct one.");
    }
}
