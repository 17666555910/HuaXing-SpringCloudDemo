package com.huaxing.designmode.factory.abstractfactory;

import lombok.extern.slf4j.Slf4j;

/**
 * @Description 美的电视机
 * @author: 姚广星
 * @time: 2021/2/18 21:08
 */
@Slf4j
public class MideaTelevision implements ITelevision{
    @Override
    public void create() {
        log.info("创建【美的牌】电视机。。。");
    }

    @Override
    public void storage() {
        log.info("【美的牌】电视机入库美的自营库。。。");
    }
}
