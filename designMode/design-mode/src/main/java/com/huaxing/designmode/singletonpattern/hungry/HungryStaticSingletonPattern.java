package com.huaxing.designmode.singletonpattern.hungry;

/**
 * @Description 饿汉式静态代码块单例模式
 * @author: 姚广星
 * @time: 2021/2/19 17:49
 */
public class HungryStaticSingletonPattern {
    /**
     * 私有构造方法
     */
    private HungryStaticSingletonPattern() {
    }

    //使用静态代码块的方式初始化实例
    private static final HungryStaticSingletonPattern HUNGRY_SINGLETON_PATTERN;

    static {
        HUNGRY_SINGLETON_PATTERN = new HungryStaticSingletonPattern();
    }

    /**
     * 向外暴漏接口
     */
    public static HungryStaticSingletonPattern getInstance() {
        return HUNGRY_SINGLETON_PATTERN;
    }
}
