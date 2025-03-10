package com.example.lab2;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class LoggingAspect {

    @Before("execution(* com.example.lab2.controller.UserController.*(..))")
    public void logRequestBody(JoinPoint joinPoint) {
        System.out.println("Aspect triggered!");
        Object[] args = joinPoint.getArgs();
        System.out.println("Request Body: " + Arrays.toString(args));
    }
}
