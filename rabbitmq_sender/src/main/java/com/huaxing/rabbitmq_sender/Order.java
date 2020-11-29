package com.huaxing.rabbitmq_sender;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @Description 订单实体
 * @author: 姚广星
 * @time: 2020/11/29 21:54
 */
@Data
public class Order {
    /**
     * 主键
     */
    private String id;
    /**
     * 订单编号
     */
    private String orderNo;
    /**
     * 商品id
     */
    private String productId;
    /**
     * 商品名称
     */
    private String productName;
    /**
     * 商品数量
     */
    private Integer number;
    /**
     * 订单金额
     */
    private BigDecimal price;
}
