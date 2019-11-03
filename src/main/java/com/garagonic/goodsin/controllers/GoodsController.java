package com.garagonic.goodsin.controllers;

import com.garagonic.goodsin.common.ErrorCodes;
import com.garagonic.goodsin.common.UIConstants;
import com.garagonic.goodsin.repository.Goods;
import com.garagonic.goodsin.service.GoodsService;
import com.garagonic.goodsin.tools.Fn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

import static java.lang.Integer.parseInt;

@Controller
public class GoodsController {
    @Autowired
    private GoodsService goodsService;

    @RequestMapping(value = "/")
    public ModelAndView searchAdd(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("goodsInPage");
        if (request.getParameter("search") != null) {
            Goods goods = search(request, response);
            Boolean inStockOnly = UIConstants.CHECK_BOX_ON.equals(request.getParameter("inStockOnly"));
            try {
                List<Goods> goodsList = goodsService.getGoodsList(goods, inStockOnly);
                mv.addObject("goodsList", goodsList);
                mv.addObject("lastGoodsSearchFilter", goods);
                mv.addObject("inStockOnly", inStockOnly);
                request.getSession().setAttribute("lastGoodsSearchFilter", goods);
                request.getSession().setAttribute("inStockOnly", inStockOnly);
            } catch (RuntimeException re) {
                if (ErrorCodes.EMPTY_SEARCH.equals(re.getMessage())) {
                    mv.addObject("showErrorMessage", Boolean.TRUE);
                    mv.addObject("lastGoodsSearchFilter", goods);
                    mv.addObject("inStockOnly", inStockOnly);
                } else {
                    throw re;
                }
            }
            mv.setViewName("goodsInPage");
        } else if (request.getParameter("addGoods") != null) {
            mv.setViewName("addGoodsPage");
        } else {
            Object lastGoodsSearchFilter = request.getSession().getAttribute("lastGoodsSearchFilter");
            if (lastGoodsSearchFilter != null) {
                Boolean inStockOnly = (Boolean) request.getSession().getAttribute("inStockOnly");
                List<Goods> goodsList = goodsService.getGoodsList((Goods) lastGoodsSearchFilter, inStockOnly);
                mv.addObject("goodsList", goodsList);
                mv.addObject("lastGoodsSearchFilter", lastGoodsSearchFilter);
                mv.addObject("inStockOnly", inStockOnly);
            }
        }
        return mv;
    }

    @RequestMapping(value = "/addGoodsPage")
    public ModelAndView AddGoodsPage(HttpServletRequest request, HttpServletResponse response) {
        Goods goods;
        boolean errorsPresent = false;
        ModelAndView mv = new ModelAndView();
        mv.setViewName("addGoodsPage");
        if (request.getParameter("cancel") != null) {
            mv.setViewName("redirect:/");
        } else if (request.getParameter("addGoods") != null) {
            goods = getGoodsFromRequest(request, 0);
            try {
                goodsService.addGoods(goods);
            } catch (RuntimeException re) {
                if (ErrorCodes.CUSTOMER_AND_LOCATION_REQUIRED.equals(re.getMessage())) {
                    mv.addObject("showErrorMessage", Boolean.TRUE);
                    mv.addObject("addedGoods", goods);
                    mv.setViewName("addGoodsPage");
                    errorsPresent = true;
                } else {
                    throw re;
                }
            }
            if (!errorsPresent) {
                mv.addObject("addedGoods", null);
                List<Goods> goodsList = goodsService.getGoodsList(goods);
                mv.addObject("goodsList", goodsList);
                mv.addObject("inStockOnly", Boolean.FALSE);
                request.getSession().setAttribute("inStockOnly", Boolean.FALSE);
                request.getSession().setAttribute("lastGoodsSearchFilter", goods);
                mv.setViewName("goodsInPage");
            }
        }
        return mv;
    }

    private Goods getGoodsFromRequest(HttpServletRequest request, int id) {
        Goods goods = new Goods();
        goods.setId(id);
        goods.setPo(convertParameterToInt(request, "po"));
        goods.setWo(convertParameterToInt(request, "wo"));
        goods.setSo(convertParameterToInt(request, "so"));
        goods.setCustomer(request.getParameter("customer"));
        goods.setTitle(request.getParameter("title"));
        goods.setRack(request.getParameter("rack"));
        goods.setShelf(request.getParameter("shelf"));
        goods.setShelfPosition(convertParameterToInt(request, "shelfPosition"));

        /**
         *  default values
         */
        goods.setInDate(new java.util.Date());
        goods.setInStock(true);
        return goods;
    }


    private Integer convertParameterToInt(HttpServletRequest request, String parameterName) {
        String parameter = request.getParameter(parameterName);
        return Fn.isStringEmpty(parameter) ? 0 : parseInt(parameter);
    }

    private Goods search(HttpServletRequest request, HttpServletResponse response) {
        Goods goods = getGoodsFromRequest(request, 0);
        return goods;
    }

    @RequestMapping(value = "/{id}/delete")
    public ModelAndView deleteGoods(HttpServletRequest request, @PathVariable("id") int id) {
        goodsService.removeGoods(id);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("redirect:../");
        return mv;
    }

    @RequestMapping(value = "/{id}/edit")
    public ModelAndView openEditGoodsPage(@PathVariable("id") int id) {
        Goods goods = goodsService.getGoods(id);
        ModelAndView mv = new ModelAndView();
        mv.addObject("goods", goods);
        mv.setViewName("editGoodsPage");
        goodsService.addGoods(goods);
        return mv;
    }

    @RequestMapping(value = "/{id}/edit/submit")
    public ModelAndView editGoods(@PathVariable("id") int id, HttpServletRequest request, HttpServletResponse response) {
        if (request.getParameter("submit") != null) {
            Goods editedGoods = getGoodsFromRequest(request, id);
            goodsService.updateGoods(editedGoods);
        }
        ModelAndView mv = new ModelAndView();
        mv.setViewName("redirect:../../");
        return mv;
    }
}
