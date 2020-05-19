package com.mine.docdemo.strategy;

public enum States {

    STATE_INIT(1, "init"),
    STATE_ANALYSIS(2, "analysis"),
    STATE_SUBMIT(3, "submit"),
    ;

    States(int state, String code) {
        this.state = state;
        this.code = code;
    }

    private int state;
    private String code;
}
