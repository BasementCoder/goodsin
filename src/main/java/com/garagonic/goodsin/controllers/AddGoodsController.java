package com.garagonic.goodsin.controllers;

import com.garagonic.goodsin.repository.Goods;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class AddGoodsController {

    @RequestMapping("/goodsInPage")
    public String add(HttpServletRequest request, HttpServletResponse response){
        Goods goods = new Goods();
        goods.setPO(Integer.parseInt(request.getParameter("po")));
        goods.setPO(Integer.parseInt(request.getParameter("wo")));
        goods.setPO(Integer.parseInt(request.getParameter("so")));
        return "test";
    }


//        @Autowired
//        private GoodsRepository repository;
//
//        @RequestMapping(value = "goods", method = RequestMethod.GET)
//        public List<Goods> list() {
//            return repository.findAll();
//        }
//
//        @RequestMapping(value = "goods", method = RequestMethod.POST)
//        public Goods create(@RequestBody Goods goods) {
//            return repository.saveAndFlush(goods);
//        }
//
//        @RequestMapping(value = "goods/{id}", method = RequestMethod.GET)
//        public Goods get(@PathVariable Long id) {
//            return (Goods) repository.findAll();
//        }
//
//        @RequestMapping(value = "goods/{id}", method = RequestMethod.PUT)
//        public Goods update(@PathVariable Long id, @RequestBody Goods goods) {
////            Goods goods = repository.findOne(id);
//            BeanUtils.copyProperties(goods, goods);
//            return repository.saveAndFlush(goods);
//        }
//
//        @RequestMapping(value = "goods/{id}", method = RequestMethod.DELETE)
//        public Goods delete(@PathVariable Long id) {
//            Goods goods = (Goods) repository.findAll();
//            repository.delete(goods);
//            return goods;
//        }
}
