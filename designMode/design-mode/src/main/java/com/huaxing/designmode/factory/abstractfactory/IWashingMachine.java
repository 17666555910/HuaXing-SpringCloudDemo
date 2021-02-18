package com.huaxing.designmode.factory.abstractfactory;

/**
 * @Description 洗衣机抽象类
 * @author: 姚广星
 * @time: 2021/2/18 20:58
 */
public interface IWashingMachine {
    /**
     * 创建洗衣机
     */
    void create();

    /**
     * 入库
     */
    void storage();
}
