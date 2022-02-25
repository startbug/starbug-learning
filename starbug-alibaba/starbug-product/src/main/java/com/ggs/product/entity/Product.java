package com.ggs.product.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

/**
 * <p>
 * 商品表
 * </p>
 *
 * @author Starbug
 * @since 2022-01-25
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "Product对象", description = "商品表")
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("商品ID")
    private Long id;

    @ApiModelProperty("商品分类  1.日用品  2.零食  3.水果")
    private Integer category;

    @ApiModelProperty("商品名称")
    private String name;

    @ApiModelProperty("价格")
    private BigDecimal price;

    @ApiModelProperty("创建时间")
    private LocalDate createTime;

}
