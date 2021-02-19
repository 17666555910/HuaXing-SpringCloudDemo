package com.huaxing.designmode.singletonpattern.hungry;

/**
 * @Description 饿汉式单例模式
 * @author: 姚广星
 * @time: 2021/2/19 17:49
 */
public class HungrySingletonPattern {
    /**
     * 私有构造方法
     */
    private HungrySingletonPattern() {
    }

    /**
     * 创建个私有的对象
     */
    //private static final HungrySingletonPattern HUNGRY_SINGLETON_PATTERN = new HungrySingletonPattern();

    //使用静态代码块的方式初始化实例
    private static final HungrySingletonPattern HUNGRY_SINGLETON_PATTERN;

    static {
        HUNGRY_SINGLETON_PATTERN = new HungrySingletonPattern();
    }
    /**
     * 向外暴漏接口
     */
    public static HungrySingletonPattern getInstance() {
        return HUNGRY_SINGLETON_PATTERN;
    }
}
