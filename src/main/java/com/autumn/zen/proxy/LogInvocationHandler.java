package com.autumn.zen.proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 拦截器
 *
 * @author wuliang
 * @create 2019-06-06
 */
public class LogInvocationHandler implements InvocationHandler {

    private Object target;

    LogInvocationHandler(Object target) {
        this.target = target;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("proxy = " + proxy.getClass().getCanonicalName());
        return method.invoke(target, args);
    }


    public interface O {
        void foo();
    }

    public static class A implements O {
        @Override
        public void foo() {
            System.out.println("foo");
        }
    }

    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(A.class);
        enhancer.setCallback(new MethodInterceptor() {
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable{
                System.out.println(o.getClass().getCanonicalName());
                return o;
            }
        });
        A x = (A) enhancer.create();
        x.foo();


    }
}
