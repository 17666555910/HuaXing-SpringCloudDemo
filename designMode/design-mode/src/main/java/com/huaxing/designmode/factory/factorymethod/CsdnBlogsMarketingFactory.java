package com.huaxing.designmode.factory.factorymethod;

import com.huaxing.designmode.factory.CsdnBlogsMarketing;
import com.huaxing.designmode.factory.IBlogsMarketing;
import lombok.extern.slf4j.Slf4j;

/**
 * @Description 抽象工厂设计模式中的 CSDN 博客营销工厂
 * @author: 姚广星
 * @time: 2021/2/17 20:50
 */
@Slf4j
public class CsdnBlogsMarketingFactory extends BlogsMarketingFactoryMethod {
    @Override
    public IBlogsMarketing getBlogsMarketing() {
        log.info("创建CSDN 博客的复杂逻辑 ----");
        return new CsdnBlogsMarketing();
    }
}
