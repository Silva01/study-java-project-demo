package br.net.silva.daniel.spring.aop.study.controller;

import br.net.silva.daniel.spring.aop.study.annotation.LogAnnotationTime;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class BaseController {

    @GetMapping("/hello")
    @ResponseStatus(HttpStatus.OK)
    @LogAnnotationTime
    public String hello() {
        return "Hello World!";
    }
}
