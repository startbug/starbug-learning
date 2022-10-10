package com.ggs.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class OrderStatistics implements Serializable {

    /**
     * 城市
     */
    private String city;

    /**
     * 公司id
     */
    private Long companyId;

    /**
     * 运营商id
     */
    private Long operatorId;

    /**
     * 点位id
     */
    private Long positionId;

    /**
     * 商家id
     */
    private Long merchantStoreId;

    /**
     * 餐段, 1:早餐,2:午餐,3:晚餐,4:宵夜,5:下午茶
     */
    private Integer intervalNo;

    /**
     * 周期范围: 0: 日, 1: 周, 2: 月
     */
    private Integer periodRange;

    /**
     * 订单数
     */
    private int orderCount;

    /**
     * 用餐人数
     */
    private int diningCount;

    /**
     * 个人支付
     */
    private int actualPrice;

    /**
     * 公司支付
     */
    private int companyPrice;

    /**
     * 钱包支付
     */
    private int walletPrice;

    /**
     * 优惠券支付
     */
    private int couponPrice;

    /**
     * 第三方钱包支付
     */
    private int thirdWalletPrice;

    /**
     * 好评数量
     */
    private int positiveComment;

    /**
     * 中评数量
     */
    private int neutralComment;

    /**
     * 差评数量
     */
    private int negativeComment;

    /**
     * 投诉数量
     */
    private int complaintCount;

    /**
     * 未处理
     */
    private int unhandledComplaintCount;

    /**
     * <p>统计维度类型,主要用于用餐人数的统计,其他数据统计默认使用类型4</p>
     * <p>0:公司</p>
     * <p>1:城市</p>
     * <p>2:点位</p>
     * <p>3:点位 餐段</p>
     * <p>4:点位 商家 餐段</p>
     * <p>5:运营商 点位</p>
     * <p>6:运营商 点位 餐段</p>
     * <p>7:运营商 点位 商家</p>
     * <p>8:运营商 点位 商家 餐段</p>
     */
    private Integer statisticalType;

    /**
     * 统计日期(日：yyyy.MM.dd，周：yyyy.MM.dd-yyyy.MM.dd，月：yyyy.MM)
     */
    private String statisticalDate;

    /**
     * 客单价
     */
    private int averageAmount;

}
