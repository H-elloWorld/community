package com.pi.community.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Mendax
 * @date 2019/12/26
 **/
@Controller
public class LoginController {
    @RequestMapping("/login")
    @ResponseBody
    public void login(@RequestParam("account")String account,
                        @RequestParam("password")String password){
        System.out.println("account = " + account);
        System.out.println("password = " + password);
    }
}
