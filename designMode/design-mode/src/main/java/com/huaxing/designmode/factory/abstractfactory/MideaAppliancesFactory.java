package com.huaxing.designmode.factory.abstractfactory;

import lombok.extern.slf4j.Slf4j;

/**
 * @Description 美的牌家电工厂类
 * @author: 姚广星
 * @time: 2021/2/18 21:12
 */
@Slf4j
public class MideaAppliancesFactory {

    public IRefrigerator createRefrigerator() {
        log.info("创建美的牌冰箱的复杂逻辑。。。");
        return new MideaRefrigerator();
    }

    public ITelevision createTelevision() {
        log.info("创建美的牌电视机的复杂逻辑。。。");
        return new MideaTelevision();
    }

    public IWashingMachine createWashingMachine() {
        log.info("创建美的牌洗衣机的复杂逻辑。。。");
        return new MideaWashingMachine();
    }
}
