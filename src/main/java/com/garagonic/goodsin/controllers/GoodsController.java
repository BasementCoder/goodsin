package com.garagonic.goodsin.controllers;

import com.garagonic.goodsin.repository.Goods;
import com.garagonic.goodsin.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

import static java.lang.Integer.parseInt;

@Controller
public class GoodsController {
    @Autowired
    private GoodsService goodsService;

    @RequestMapping(value = "/goodsInPage")
    public ModelAndView searchAdd(HttpServletRequest request, HttpServletResponse response) {

        if (request.getParameter("search") != null) {
            return search(request, response);
        }
        else if (request.getParameter("addGoods") != null)
        {
            return add(request, response);
        }

        List<Map> goodsList = goodsService.getGoods();
        ModelAndView mv = new ModelAndView();
        mv.addObject("goodsList", goodsList);
        mv.setViewName("goodsInPage");
        return mv;
    }

    private ModelAndView add(HttpServletRequest request, HttpServletResponse response) {
        Goods goods = new Goods();
        goods.setPO(parseInt(request.getParameter("po")));
        goods.setWO(parseInt(request.getParameter("wo")));
        goods.setSO(parseInt(request.getParameter("so")));
        goods.setCustomer(request.getParameter("customer"));
        goods.setTitle(request.getParameter("title"));
        goods.setRack(request.getParameter("rack"));
        goods.setShelf(request.getParameter("shelf"));
        goods.setShelfPosition(parseInt(request.getParameter("shelfPosition")));
        goods.setInDate(new java.util.Date());
        goods.setInStock(true);

//        Goods goods = new Goods();
//        goods.setPO(1);
//        goods.setWO(2);
//        goods.setSO(3);
//        goods.setCustomer("customer");
//        goods.setTitle("title");
//        goods.setRack("1");
//        goods.setShelf("s");
//        goods.setShelfPosition(1);
//        goods.setInStock(true);
        goodsService.addGoods(goods);

        List<Map> goodsList = goodsService.getGoods();


        ModelAndView mv = new ModelAndView();
        mv.addObject("goodsList", goodsList);
        mv.setViewName("goodsInPage");
        return mv;
    }


    private ModelAndView search(HttpServletRequest request, HttpServletResponse response) {

        List<Map> goodsList = goodsService.getGoods();


        ModelAndView mv = new ModelAndView();
        mv.addObject("goodsList", goodsList);
        mv.setViewName("goodsInPage");
        return mv;

    }

    @RequestMapping(value = "goodsInPage/delete/{id}")
    public ModelAndView remove(@PathVariable("id") int id) {

        goodsService.removeGoods(id);
        List<Map> goodsList = goodsService.getGoods();


        ModelAndView mv = new ModelAndView();
        mv.addObject("goodsList", goodsList);
        mv.setViewName("redirect:/goodsInPage");
        return mv;
    }
}
