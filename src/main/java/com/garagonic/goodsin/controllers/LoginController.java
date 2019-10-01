package com.garagonic.goodsin.controllers;

import com.garagonic.goodsin.service.LoginServise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class LoginController {

    @Autowired
    LoginServise loginServise;

    @RequestMapping("/login")
    public ModelAndView login(@RequestParam("username") String username, @RequestParam("password") String password, HttpServletRequest request, HttpServletResponse response) {

        boolean loggedIn = loginServise.login(username, password);
//        int k = as.add(i, j);

        ModelAndView mv = new ModelAndView();
        if (loggedIn) {
//            mv.setViewName("display");
            mv.setViewName("mainMenuPage");
            mv.addObject("result", username + ", you have logged in successfully");
        }
        else
        {
            mv.setViewName("login");
            mv.addObject(   "message", "Error logging in. Please try again.");
        }

        return mv;
    }

}
