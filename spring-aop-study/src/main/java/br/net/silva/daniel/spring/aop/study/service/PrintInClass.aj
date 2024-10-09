package br.net.silva.daniel.spring.aop.study.service;

public aspect TracingAspect {

    pointcut traceAnnotatedClasses(): within(@PrintInClass *) && execution(* *(..));

    Object around() : traceAnnotatedClasses() {
        String signature = thisJoinPoint.getSignature().toShortString();
        System.out.println("Entering " + signature);
        try {
            return proceed();
        } finally {
            System.out.println("Exiting " + signature);
        }
    }

    after() throwing (Exception e) : traceAnnotatedClasses() {
        System.out.println("Exception thrown from " + thisJoinPoint.getSignature().toShortString());
    }
}