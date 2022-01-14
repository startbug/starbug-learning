package com.ggs.excel.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

/**
 * @Author lianghaohui
 * @Date 2022/1/14 16:01
 * @Description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    private String id;

    private String orderSn;

    private Date createTime;

    private String receiverAddress;

    private Member member;

    private List<Product> productList;

}
