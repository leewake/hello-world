package com.pangpang.mvnbook.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by leewake on 2017/7/10 0010.
 */

@Controller
public class HelloController {
        @RequestMapping("/hello")
        @ResponseBody
        public String home(){
            return "Hello, World!";
        }
}
