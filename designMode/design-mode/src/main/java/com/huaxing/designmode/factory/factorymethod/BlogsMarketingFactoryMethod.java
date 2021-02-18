package com.huaxing.designmode.factory.factorymethod;

import com.huaxing.designmode.factory.IBlogsMarketing;

/**
 * @Description 抽象工厂设计模式中的抽象工厂
 * @author: 姚广星
 * @time: 2021/2/17 20:52
 */
public abstract class BlogsMarketingFactoryMethod {

    /**
     * 获取具体的博客营销方式
     *
     * @return
     */
    public abstract IBlogsMarketing getBlogsMarketing();
}
