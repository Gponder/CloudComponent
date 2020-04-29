package com.ponder.technology.proxy;

/**
 * @auth ponder
 * @Email gponder.g@gmail.com
 * @create 2020/4/28 15:50
 */
public interface AOPInterface {

    /**
     * 正常接口可以做一些事情也可以什么也不做
     * 不继承接口通过动态代理实现接口调用
     * aop 在动态代理时额外做一些操作
     */
    void doing();

}
