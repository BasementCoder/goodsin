package com.garagonic.goodsin.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class MainMenuController {

    @RequestMapping("/mainMenu")
    public ModelAndView goodsInOption(HttpServletRequest request, HttpServletResponse response) {

        ModelAndView mv = new ModelAndView();
        mv.setViewName("goodsInPage");
        return mv;
    }

}
