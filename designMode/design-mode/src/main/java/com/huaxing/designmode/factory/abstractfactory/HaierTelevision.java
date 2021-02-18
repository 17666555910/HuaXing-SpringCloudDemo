package com.huaxing.designmode.factory.abstractfactory;

import lombok.extern.slf4j.Slf4j;

/**
 * @Description 海尔电视机
 * @author: 姚广星
 * @time: 2021/2/18 21:08
 */
@Slf4j
public class HaierTelevision implements ITelevision{
    @Override
    public void create() {
        log.info("创建【海尔牌】电视机。。。");
    }

    @Override
    public void storage() {
        log.info("【海尔牌】电视机入库海尔自营库。。。");
    }
}
