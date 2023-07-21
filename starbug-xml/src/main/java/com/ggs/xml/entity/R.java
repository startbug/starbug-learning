package com.ggs.xml.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class R<T> {

    private Integer code;

    private String msg;

    private T data;

    public static <T> R ok(T data) {
        return R.builder().code(200).msg("操作成功").data(data).build();
    }

    public static <T> R ok(T data, String msg) {
        return R.builder().code(200).msg(msg).data(data).build();
    }

    public static <T> R fail(String msg) {
        return R.builder().code(500).msg(msg).build();
    }

    public static <T> R fail(Integer code, String msg) {
        return R.builder().code(code).msg(msg).build();
    }

}
