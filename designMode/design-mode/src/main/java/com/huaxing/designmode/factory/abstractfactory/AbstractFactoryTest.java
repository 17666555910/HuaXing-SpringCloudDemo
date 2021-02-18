package com.huaxing.designmode.factory.abstractfactory;

/**
 * @Description 模板方法设计模式测试类
 * @author: 姚广星
 * @time: 2021/2/18 21:19
 */
public class AbstractFactoryTest {

    public static void main(String[] args) {
        HaierAppliancesFactory haierAppliancesFactory = new HaierAppliancesFactory();
        IRefrigerator refrigerator = haierAppliancesFactory.createRefrigerator();
        refrigerator.create();
        refrigerator.storage();
        ITelevision television = haierAppliancesFactory.createTelevision();
        television.create();
        television.storage();

        MideaAppliancesFactory mideaAppliancesFactory = new MideaAppliancesFactory();
        IRefrigerator refrigerator1 = mideaAppliancesFactory.createRefrigerator();
        refrigerator1.create();
        refrigerator1.storage();
        ITelevision television1 = mideaAppliancesFactory.createTelevision();
        television1.create();
        television1.storage();
    }
}
