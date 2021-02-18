package com.huaxing.designmode.factory.abstractfactory;

import lombok.extern.slf4j.Slf4j;

/**
 * @Description 海尔牌家电工厂类
 * @author: 姚广星
 * @time: 2021/2/18 21:12
 */
@Slf4j
public class HaierAppliancesFactory {

    public IRefrigerator createRefrigerator() {
        log.info("创建海尔牌冰箱的复杂逻辑。。。");
        return new HaierRefrigerator();
    }

    public ITelevision createTelevision() {
        log.info("创建海尔牌电视机的复杂逻辑。。。");
        return new HaierTelevision();
    }

    public IWashingMachine createWashingMachine() {
        log.info("创建海尔牌洗衣机的复杂逻辑。。。");
        return new HaierWashingMachine();
    }
}
