package com.huaxing.designmode.singletonpattern.lazy;

/**
 * @Description 懒汉式单例模式
 * @author: 姚广星
 * @time: 2021/2/19 18:57
 */
public class LazySimpleSingleton {

    private LazySimpleSingleton() {
    }

    private static LazySimpleSingleton LAZY_SIMPLE_SINGLETON;

    public static LazySimpleSingleton getInstance() {
        if (null == LAZY_SIMPLE_SINGLETON) {
            LAZY_SIMPLE_SINGLETON = new LazySimpleSingleton();
        }
        return LAZY_SIMPLE_SINGLETON;
    }
}
