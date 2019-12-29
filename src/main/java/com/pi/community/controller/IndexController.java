package com.pi.community.controller;

import com.pi.community.entity.User;
import com.pi.community.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * @author Mendax
 * @date 2019/12/19
 **/
@Controller
public class IndexController {

    @Autowired()
    private UserMapper userMapper;

    /**Index页面
     * @param request
     * @return
     */
    @GetMapping("/")
    public String index(HttpServletRequest request){
        //持久化登陆状态
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie: cookies) {
                String name = cookie.getName();
                if ("token".equals(name)) {
                    String token = cookie.getValue();
                    User user = userMapper.getUser(token);
                    if (user != null) {
                        request.getSession().setAttribute("user",user);
                    }
                    break;
                }
            }
            return "index";
        }
        return "index";
    }

    /**博客页面
     * @return
     */
    @GetMapping("/blog")
    public String blog(){
        return "blog";
    }


}
