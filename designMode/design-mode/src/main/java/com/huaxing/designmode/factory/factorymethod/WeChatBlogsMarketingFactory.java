package com.huaxing.designmode.factory.factorymethod;

import com.huaxing.designmode.factory.IBlogsMarketing;
import com.huaxing.designmode.factory.WeChatBlogsMarketing;
import lombok.extern.slf4j.Slf4j;

/**
 * @Description 抽象工厂设计模式中的 微信公众号营销工厂
 * @author: 姚广星
 * @time: 2021/2/17 20:48
 */
@Slf4j
public class WeChatBlogsMarketingFactory extends BlogsMarketingFactoryMethod {

    @Override
    public IBlogsMarketing getBlogsMarketing() {
        log.info("创建微信 博客的复杂逻辑 ----");
        return new WeChatBlogsMarketing();
    }
}
