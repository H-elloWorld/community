package com.pi.community.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Mendax
 */
@Controller
public class TestController {
    @RequestMapping("/test")
    public String testController(@RequestParam(name = "name") String name, Model model){
        model.addAttribute("name",name);
        return "index";
    }
}
