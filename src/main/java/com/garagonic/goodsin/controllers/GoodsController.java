package com.garagonic.goodsin.controllers;

import com.garagonic.goodsin.repository.Goods;
import com.garagonic.goodsin.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

@Controller
public class GoodsController {
    @Autowired
    private GoodsService goodsService;

    @RequestMapping(value = "/goodsInPage", params = "addGoods")
    public ModelAndView add(HttpServletRequest request, HttpServletResponse response) {
        Goods goods = new Goods();
        goods.setPO(Integer.parseInt(request.getParameter("po")));
        goods.setWO(Integer.parseInt(request.getParameter("wo")));
        goods.setSO(Integer.parseInt(request.getParameter("so")));
        goodsService.addGoods(goods);

        ModelAndView mv = new ModelAndView();
        mv.setViewName("goodsInPage");
        return mv;
    }

    @RequestMapping(value = "/goodsInPage", params = "search")
    public ModelAndView search(HttpServletRequest request, HttpServletResponse response) {

        List<Map> goodsList = goodsService.getGoods();


        ModelAndView mv = new ModelAndView();
        mv.addObject("goodsList", goodsList);
        mv.setViewName("goodsInPage");
        return mv;

    }

}
