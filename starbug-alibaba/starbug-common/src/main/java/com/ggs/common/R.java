package com.ggs.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author lianghaohui
 * @Date 2022/2/11 11:44
 * @Description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class R {

    private String message;
    private String code;
    private Object data;

    public static R ok(Object data) {
        return new R("success", "200", data);
    }

    public static R fail(String message) {
        return new R("500", message, null);
    }

    public R data(Object data) {
        this.data = data;
        return this;
    }

    public R message(String message) {
        this.message = message;
        return this;
    }

    public R code(String code) {
        this.code = code;
        return this;
    }

}
