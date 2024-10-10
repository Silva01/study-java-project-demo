package br.net.silva.daniel.spring.aop.study.component;

import br.net.silva.daniel.spring.aop.study.annotation.PrintInClass;
import br.net.silva.daniel.spring.aop.study.annotation.Proccess;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
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
        System.out.println("Parametros do metodo " + joinPoint.getArgs()[0]);
        return joinPoint.proceed();
    }

    @Pointcut("within(@br.net.silva.daniel.spring.aop.study.annotation.PrintInClass *) && execution(* *(..))")
    public void processing() {}

    // Antes da execução de qualquer método em classes anotadas com @PrintInClass
    @After("processing()")
    public void logBefore(JoinPoint joinPoint) {

        Class<?> targetClass = joinPoint.getTarget().getClass();

        // Obtém a anotação da classe
        PrintInClass annotation = targetClass.getAnnotation(PrintInClass.class);
        if (annotation != null) {
            // Captura o valor passado para a anotação
            String annotationValue = annotation.value();
            System.out.println("Executing method: " + joinPoint.getSignature().getName() +
                                       " in class: " + annotationValue);
        }
    }
}
