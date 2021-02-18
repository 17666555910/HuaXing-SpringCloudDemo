package com.huaxing.designmode.factory.abstractfactory;

import lombok.extern.slf4j.Slf4j;

/**
 * @Description 美的冰箱
 * @author: 姚广星
 * @time: 2021/2/18 21:04
 */
@Slf4j
public class MideaRefrigerator implements IRefrigerator {
    @Override
    public void create() {
        log.info("创建【美的牌】冰箱。。。");
    }

    @Override
    public void storage() {
        log.info("【美的牌】冰箱入库美的自营库。。。");
    }
}
