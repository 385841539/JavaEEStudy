package com.itheimaioc.proxy.impl;

import com.itheimaioc.proxy.IProducer;
import org.springframework.cglib.proxy.Enhancer;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class TestProxy {

    public static void main(String[] args) {


         final ProducerImpl producer = new ProducerImpl();
        IProducer producer1 = (IProducer)Proxy.newProxyInstance(producer.getClass().getClassLoader(), producer.getClass().getInterfaces(), new InvocationHandler() {
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//                System.out.println("---proxy：" + proxy);
                System.out.println("---method：" + method.getName());
                System.out.println("---args：" + args);
                Float arg = (Float) args[0];
                if (method.getName().equals("saleProduct")){
                    return  method.invoke(producer,arg*0.8f);
                }else {

//                    Enhancer.create()
//
                    return  method.invoke(producer,args);
                }
            }
        });


        producer1.saleProduct(100.0f);
        producer1.serviceProduct(180.0f);

    }
}
