package com.pangpang.mvnbook.helloworld;

import com.pangpang.mvnbook.controller.HelloController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by leewake on 2017/7/10 0010.
 */

@SpringBootApplication//(scanBasePackageClasses = HelloController.class)
@ComponentScan(basePackageClasses = HelloController.class)
@EnableAutoConfiguration
@RestController
public class HelloWorld {

    public static void main(String[] args){
        SpringApplication.run(HelloWorld.class, args);
    }

    @RequestMapping("/")
    public String hello(){
        return "Hello World";
    }

}
