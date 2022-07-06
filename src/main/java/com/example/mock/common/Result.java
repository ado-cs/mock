package com.example.mock.common;

import lombok.Data;

@Data
public class Result {
    private int code;
    private String message;
    private Object data;

    public static final Result SUCCESS = new Result();
    public static final Result INVALID_PARAMETER = error(1, "输入不合法");
    public static final Result NA_DATA = error(2, "记录不存在");

    public static Result ok(Object data) {
        Result result = new Result();
        result.data = data;
        return result;
    }

    public static Result error(String message) {
        return error(-1, message);
    }

    private static Result error(int code, String message) {
        Result result = new Result();
        result.code = code;
        result.message = message;
        return result;
    }
}
