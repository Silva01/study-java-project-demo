package br.net.silva.daniel.spring.aop.study.service;

import br.net.silva.daniel.spring.aop.study.annotation.PrintInClass;
import br.net.silva.daniel.spring.aop.study.annotation.Proccess;
import org.springframework.stereotype.Service;

@Service
@PrintInClass
public class HelloService {

    @Proccess(name = "HelloService")
    public String procced(String message) {
        return "Message Procced for HelloService: %s".formatted(message);
    }
}
