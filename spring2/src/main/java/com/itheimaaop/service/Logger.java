package com.itheimaaop.service;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.aop.aspectj.MethodInvocationProceedingJoinPoint;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;


@Component
@Aspect
@EnableAspectJAutoProxy
public class Logger {




    @Pointcut("execution( * com.itheimaaop.service.impl.*.*(..))")
    private void pt1(){}



//    @Before("pt1()")
    public  void beforePrintLog(){

        System.out.println("--Logger--beforePrintLog---");

    }


//    @AfterReturning("pt1()")
    public  void afterReturningPrintLog(){

        System.out.println("--Logger--afterReturningPrintLog---");

    }

//

    @Around("pt1()")
    public  Object aroundPrintLog(ProceedingJoinPoint pjp){

        Object rtValue=null;
        try {

            System.out.println("--Logger--beforePrintLog---");
            Object[] args = pjp.getArgs();

             rtValue = pjp.proceed(args);
            System.out.println("--Logger--afterReturningPrintLog---");

            return  rtValue;


        }catch (Throwable e){
            System.out.println("--Logger--afterThrowingPrintLog---");
            throw new RuntimeException(e);

        }  finally {

            System.out.println("--Logger--afterPrintLog---");

        }

    }






//    @AfterThrowing("pt1()")
    public  void afterThrowingPrintLog(){

        System.out.println("--Logger--afterThrowingPrintLog---");

    }


//    @After("pt1()")
    public  void afterPrintLog(){

        System.out.println("--Logger--afterPrintLog---");

    }

}
