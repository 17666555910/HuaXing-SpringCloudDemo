package com.huaxing.designmode.factory.abstractfactory;

import lombok.extern.slf4j.Slf4j;

/**
 * @Description 海尔冰箱
 * @author: 姚广星
 * @time: 2021/2/18 21:06
 */
@Slf4j
public class HaierRefrigerator implements IRefrigerator {
    @Override
    public void create() {
        log.info("创建【海尔牌】冰箱。。。");
    }

    @Override
    public void storage() {
        log.info("【海尔牌】冰箱入库海尔自营库。。。");
    }
}
