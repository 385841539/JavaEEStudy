package com.itheimaioc.proxy;

import com.itheimaioc.domain.Account;
import com.itheimaioc.service.IAccountService;
import com.itheimaioc.utils.TransactionManger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;



@Component
public class MyBeanFactory {


    @Autowired
    TransactionManger transactionManger;


    @Autowired
    IAccountService iAccountService;

//
//    public final void setTransactionManger(TransactionManger transactionManger) {
//        this.transactionManger = transactionManger;
//    }
//
//    public final void setiAccountService(IAccountService iAccountService) {
//        this.iAccountService = iAccountService;
//    }

    public IAccountService getiAccountService() {

        System.out.println("--getiAccountService-----");
        IAccountService accountService = (IAccountService) Proxy.newProxyInstance(iAccountService.getClass().getClassLoader(), iAccountService.getClass().getInterfaces(), new InvocationHandler() {
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {


                Object returnValue = null;

                try {

                    transactionManger.beginTransaction();


                    returnValue = method.invoke(iAccountService, args);

                    transactionManger.commit();


                } catch (Exception e) {

                    transactionManger.rollback();
                } finally {

                }


                return returnValue;
            }
        });


        return accountService;

    }


}
