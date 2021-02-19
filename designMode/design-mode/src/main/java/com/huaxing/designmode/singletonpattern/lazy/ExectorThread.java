package com.huaxing.designmode.singletonpattern.lazy;

/**
 * @Description 懒汉式线程类
 * @author: 姚广星
 * @time: 2021/2/19 19:41
 */
public class ExectorThread implements Runnable {

    @Override
    public void run() {
        LazySimpleSingleton singleton = LazySimpleSingleton.getInstance();
        System.out.println(Thread.currentThread().getName() + ":" + singleton);
    }
}
