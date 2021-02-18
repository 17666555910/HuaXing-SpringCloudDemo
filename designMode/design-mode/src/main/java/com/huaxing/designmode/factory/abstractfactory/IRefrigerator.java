package com.huaxing.designmode.factory.abstractfactory;

/**
 * @Description 冰箱
 * @author: 姚广星
 * @time: 2021/2/18 21:02
 */
public interface IRefrigerator {
    /**
     * 创建
     */
    void create();

    /**
     * 入库
     */
    void storage();
}
