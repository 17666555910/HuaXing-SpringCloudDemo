package com.huaxing.designmode.factory;

/**
 * @Description 博客营销方式
 * @author: 姚广星
 * @time: 2021/2/17 20:44
 */
public interface IBlogsMarketing {

    /**
     * 创建博客
     *
     * @param msg 博客信息
     */
    void create(String msg);
}
