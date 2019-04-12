package com.test.microservivce.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspect {

    //通过 pointcut注解声明一个切点 使用 Action 注解的 地方都是切点
    @Pointcut("@annotation(com.test.microservivce.aspect.Action)")
    public void annoPointCut(){};

    @Before("annoPointCut()")
    public void aopbefore(){
        System.out.println("注解方法 before");
    }

    @After("annoPointCut()")
    public void aopafter(){
        System.out.println("注解方法 after");
    }

    @Before("execution(* com.test.microservivce.aspect.HelloService.*(..))")
    public void mthbefore(){
        System.out.println(" executionmethod方法 before");
    }

    @Before("execution(* com.test.microservivce.aspect.HelloService.*(..))")
    public void mthafter(){
        System.out.println(" execution method方法 after");
    }
}
