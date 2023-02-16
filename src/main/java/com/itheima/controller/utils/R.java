package com.itheima.controller.utils;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class R {
    private Boolean success;
    private Object data;
    private String msg;

    public static R r() {
        return new R(true, null, null);
    }
    public static R r(Boolean success) {
        return new R(success, null, null);
    }
    public static R r(Object data) {
        return new R(true, data, null);
    }
    public static R r(Boolean success, Object data) {
        return new R(success, data, null);
    }
    public static R r(Boolean success, String msg) {
        return new R(success, null, msg);
    }
    public static R fail(String msg) {
        return new R(false, null, msg);
    }
}
