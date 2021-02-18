package com.huaxing.designmode.factory.abstractfactory;

import lombok.extern.slf4j.Slf4j;

/**
 * @Description 美的洗衣机
 * @author: 姚广星
 * @time: 2021/2/18 21:09
 */
@Slf4j
public class MideaWashingMachine implements IWashingMachine{
    @Override
    public void create() {
        log.info("创建【美的牌】洗衣机。。。");
    }

    @Override
    public void storage() {
        log.info("【美的牌】洗衣机入库美的自营库。。。");
    }
}
