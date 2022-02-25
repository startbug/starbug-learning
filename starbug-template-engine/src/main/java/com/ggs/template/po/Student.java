package com.ggs.template.po;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author lianghaohui
 * @Date 2022/2/25 9:43
 * @Description
 */
@Data
public class Student implements Serializable {

    /**
     * 唯一标识id
     */
    private Integer id;
    /**
     * 姓名
     */
    private String name;
    /**
     * 年龄
     */
    private Integer age;

}
