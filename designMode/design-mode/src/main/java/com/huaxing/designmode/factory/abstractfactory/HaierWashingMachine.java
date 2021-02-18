package com.huaxing.designmode.factory.abstractfactory;

import lombok.extern.slf4j.Slf4j;

/**
 * @Description 海尔洗衣机
 * @author: 姚广星
 * @time: 2021/2/18 21:09
 */
@Slf4j
public class HaierWashingMachine implements IWashingMachine{
    @Override
    public void create() {
        log.info("创建【海尔牌】洗衣机。。。");
    }

    @Override
    public void storage() {
        log.info("【海尔牌】洗衣机入库海尔自营库。。。");
    }
}
