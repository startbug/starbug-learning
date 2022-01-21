package com.ggs.yaml.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author lianghaohui
 * @Date 2022/1/14 15:49
 * @Description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class R {

    private int code;

    private String message;

    private Object data;

    public static R ok() {
        return new R(200, "操作成功", null);
    }

    public static R failed() {
        return new R(500, "操作失败", null);
    }

    public R data(Object data) {
        this.data = data;
        return this;
    }

    public R message(String message) {
        this.message = message;
        return this;
    }

    public R code(int code) {
        this.code = code;
        return this;
    }

}
