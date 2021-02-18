package com.huaxing.designmode.factory.abstractfactory;

/**
 * @Description 电视机抽象类
 * @author: 姚广星
 * @time: 2021/2/18 21:01
 */
public interface ITelevision {
    /**
     * 创建
     */
    void create();

    /**
     * 入库
     */
    void storage();
}
