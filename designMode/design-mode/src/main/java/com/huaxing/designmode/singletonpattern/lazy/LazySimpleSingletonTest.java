package com.huaxing.designmode.singletonpattern.lazy;

import lombok.extern.slf4j.Slf4j;

/**
 * @Description 懒汉式单例测试类
 * @author: 姚广星
 * @time: 2021/2/19 17:56
 */
@Slf4j
public class LazySimpleSingletonTest {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new ExectorThread());
        Thread thread2 = new Thread(new ExectorThread());
        thread1.start();
        thread2.start();

        System.out.println("End");
    }
}
