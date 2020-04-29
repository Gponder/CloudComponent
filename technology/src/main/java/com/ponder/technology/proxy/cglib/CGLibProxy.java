package com.ponder.technology.proxy.cglib;


import com.ponder.technology.proxy.AOPClass;
import jdk.nashorn.internal.ir.CallNode;
import net.sf.cglib.beans.BeanGenerator;
import net.sf.cglib.beans.ImmutableBean;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.FixedValue;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @auth ponder
 * @Email gponder.g@gmail.com
 * @create 2020/4/29 18:52
 */
public class CGLibProxy {
    public static void main(String[] args) throws Exception {
        CGLibProxy cgLibProxy = new CGLibProxy();
//        cgLibProxy.proxyClass();
//        cgLibProxy.proxyTest();
//        cgLibProxy.immutableBean();
        cgLibProxy.beanGenerator();
    }

    private void proxyClass() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(AOPClass.class);
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                if (method.getName().equals("doOther")){
                    Object result = methodProxy.invokeSuper(o, objects);
                    return "intercept:"+result;
                }
                return null;
            }
        });
        AOPClass aopClass = (AOPClass) enhancer.create();
        System.out.println(aopClass.doOther("enhancer"));
    }

    /**
     * spring 中经常更改对象的toString
     */
    private void proxyTest() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(AOPClass.class);
        enhancer.setCallback(new FixedValue() {
            @Override
            public Object loadObject() throws Exception {
                return "ha ha ha";
            }
        });
        AOPClass aopClass = (AOPClass) enhancer.create();
        System.out.println(aopClass.doing("doing"));
        System.out.println(aopClass.doOther("do other"));
        System.out.println(aopClass.toString());
    }

    private void immutableBean(){
        AOPClass aopClass = new AOPClass();
        aopClass.setName("aop");
        AOPClass immutableBean = (AOPClass) ImmutableBean.create(aopClass); //创建不可变类
        //immutableBean.reName("Hello"); //直接修改将throw exception
        //immutableBean.name = "Hello";//没有异常 但是无法更改值
        //aopClass.setName("Hello"); //可以通过底层对象来进行修改
        System.out.println(immutableBean.getName());
    }

    private void beanGenerator() throws Exception{
        BeanGenerator beanGenerator = new BeanGenerator();
        beanGenerator.addProperty("value", String.class);
        Object myBean = beanGenerator.create();
        Method setter = myBean.getClass().getMethod("setValue", String.class);
        setter.invoke(myBean, "generator");
        Method getter = myBean.getClass().getMethod("getValue");
        System.out.println(getter.invoke(myBean));
    }

    /**
     * BeanCopier
     * BeanMap
     * MethodDelegate
     */

}
