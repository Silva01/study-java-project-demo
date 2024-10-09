package br.net.silva.daniel.spring.aop.study.controller;

import br.net.silva.daniel.spring.aop.study.annotation.LogAnnotationTime;
import br.net.silva.daniel.spring.aop.study.annotation.Proccess;
import br.net.silva.daniel.spring.aop.study.service.HelloService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class BaseController {

    private final HelloService helloService;

    @GetMapping("/hello")
    @ResponseStatus(HttpStatus.OK)
    @LogAnnotationTime
    @Proccess(name = "BaseController")
    public String hello() {
        return helloService.procced("Hello World Controller");
    }
}
