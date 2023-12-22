package com.xd;

import com.xd.impl.CalculatorPureImpl;
import com.xd.proxy.CalculatorStaticProxy;
import com.xd.proxy.dynamic.ProxyFactory;

import java.util.concurrent.Callable;

public class UseAop {
    public static void main(String[] args) {
        Calculator calculator = new CalculatorPureImpl();
        CalculatorStaticProxy proxy = new CalculatorStaticProxy(calculator);
        proxy.add(0,5);

        ProxyFactory proxyFactory = new ProxyFactory(calculator);
        Calculator proxy1 = (Calculator) proxyFactory.getProxy();
        proxy1.add(1,3);
        proxy1.sub(4,5);
    }
}
