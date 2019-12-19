package com.pi.community.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author Mendax
 * @date 2019/12/19
 **/
@Controller
public class IndexController {


    @GetMapping("blog")
    public String blog(){
        return "blog";
    }
}
