package com.xd.ioc_04;

public class JavaBean {
    /**
     * 1、必须public
     * 2、必须void
     * 3、必须无参数
     * 初始化方法：初始化业务逻辑
     */
    public void init() {
        System.out.println("javabean init");
    }

    /**
     * 销毁方法
     */
    public void clear() {
        System.out.println("javabean destory");
    }
}
