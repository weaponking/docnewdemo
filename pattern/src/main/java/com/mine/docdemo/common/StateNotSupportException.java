package com.mine.docdemo.common;

public class StateNotSupportException extends RuntimeException {

    public static final String STATE_NOT_SUPPORT = "state not support";

    public StateNotSupportException(String msg) {
        super(msg);
    }

    public StateNotSupportException() {
        super(STATE_NOT_SUPPORT);
    }
}
