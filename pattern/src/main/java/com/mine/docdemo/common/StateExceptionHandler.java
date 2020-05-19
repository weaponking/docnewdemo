package com.mine.docdemo.common;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class StateExceptionHandler {

    @ExceptionHandler(StateNotSupportException.class)
    @ResponseBody
    public Map<String, Object> handle(Exception e) {
        Map<String, Object> map = new HashMap<>();
        map.put("msg", e.getMessage());
        map.put("code", HttpStatus.BAD_REQUEST.value());
        return map;
    }
}
