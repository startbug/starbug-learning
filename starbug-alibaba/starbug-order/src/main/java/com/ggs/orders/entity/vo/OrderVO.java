package com.ggs.orders.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author lianghaohui
 * @Date 2022/2/11 16:10
 * @Description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderVO {

    /**
     * 商品数量
     */
    private int number;

    /**
     * 商品ID
     */
    private Long productId;

}
