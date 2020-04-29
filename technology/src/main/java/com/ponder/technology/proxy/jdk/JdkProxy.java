package com.ponder.technology.proxy.jdk;

import com.ponder.technology.proxy.AOPClass;
import com.ponder.technology.proxy.AOPInterface;
import com.ponder.technology.proxy.AOPInterfaceParam;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * @auth ponder
 * @Email gponder.g@gmail.com
 * @create 2020/4/28 15:57
 */
public class JdkProxy {

    /**
     * 代理类可以实现多个接口
     */
    static Class<?>[] interfaces = {AOPInterface.class, AOPInterfaceParam.class};
    /**
     * 代理过程
     */
    static InvocationHandler invocationHandler = new InvocationHandler() {
        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            if (proxy instanceof AOPInterface){
                System.out.println("doing");
                return null;
            }
            if (proxy instanceof AOPInterfaceParam){
                System.out.println("doing with param");
                return Arrays.toString(args);
            }
            return null;
        }
    };

    public static void main(String[] args){
        JdkProxy jdkProxy = new JdkProxy();
        jdkProxy.proxy();
        jdkProxy.proxyClass();
    }

    public void proxy(){
        Object object = Proxy.newProxyInstance(AOPInterfaceParam.class.getClassLoader(),interfaces,invocationHandler);
        test(object);
    }

    private void proxyClass() {
        AOPClass aopClass = new AOPClass();
        Object object = Proxy.newProxyInstance(aopClass.getClass().getClassLoader(), aopClass.getClass().getInterfaces(), (Object proxy, Method method, Object[] args) -> {
            System.out.println("doing"+Arrays.toString(args));
            Object result = method.invoke(aopClass, args);
            return result;
        });
        test(object);
    }


    private void test(Object object) {
        if (object instanceof AOPInterface){
            AOPInterface aopInterface = (AOPInterface) object;
            aopInterface.doing();
        }
        if (object instanceof AOPInterfaceParam){
            AOPInterfaceParam aopInterfaceParam = (AOPInterfaceParam) object;
            aopInterfaceParam.doing("调用参数");
        }
    }

}
