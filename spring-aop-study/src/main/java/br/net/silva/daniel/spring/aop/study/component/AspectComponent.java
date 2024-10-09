package br.net.silva.daniel.spring.aop.study.component;

import br.net.silva.daniel.spring.aop.study.annotation.PrintInClass;
import br.net.silva.daniel.spring.aop.study.annotation.Proccess;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AspectComponent {

    @Around("@annotation(br.net.silva.daniel.spring.aop.study.annotation.LogAnnotationTime)")
    public Object printLog(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("Log printado via AOP");
        var proceed = joinPoint.proceed();
        return "Resultado do método: " + proceed;
    }

    @Around("@annotation(proccess)")
    public Object processing(ProceedingJoinPoint joinPoint, Proccess proccess) throws Throwable {
        System.out.println("Log printado via AOP Com Multiplos processamentos " + proccess.name());
        return joinPoint.proceed();
    }
}
