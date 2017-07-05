package com.lpf.proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 动态代理类
 * 实现了一个方法拦截器接口
 * Created by lpf on 2017/7/4 0004.
 */
public class DynamicProxy implements MethodInterceptor {
    //被代理对象
    Object targetObject;

    public Object getProxyObject(Object object){
        this.targetObject = object;
        //增强器，动态代码生成器
        Enhancer enhancer = new Enhancer();
        //回调方法
        enhancer.setCallback(this);
        //设置生成类的父类类型
        enhancer.setSuperclass(targetObject.getClass());
        //动态生成字节码并返回代理对象
        return enhancer.create();
    }
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        //被植入的横切内容，开始时间  before
        long start = System.currentTimeMillis();
        //调用方法
        Object result = methodProxy.invoke(targetObject,objects);
        //被植入的横切内容，结束时间
        long span = System.currentTimeMillis()-start;
        System.out.println("共用时:"+span);
        return result;
    }
}
