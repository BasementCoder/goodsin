package com.garagonic.goodsin.service;

import com.garagonic.goodsin.repository.Goods;
import com.garagonic.goodsin.repository.GoodsRepository;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.*;

@Service
public class GoodsService {

    @Autowired
    private GoodsRepository goodsRepository;

    public void addGoods(Goods goods) {

        if (goods != null) {
            goodsRepository.save(goods);
        } else {
            throw new RuntimeException("Goods cannot be null.");
        }
    }

    public List<Map> getGoods() {
        List<Goods> all = goodsRepository.findAll();
        List<Map> mapList = new ArrayList<>();
        for (Goods goods : all) {
            Map<String, Object> result = new HashMap<>();
            result.put("id", goods.getId());
            result.put("po", goods.getPO());
            result.put("wo", goods.getWO());
            result.put("so", goods.getSO());
            result.put("customer", goods.getCustomer());
            result.put("title", goods.getTitle());
            result.put("rack", goods.getRack());
            result.put("shelf", goods.getShelf());
            result.put("shelfPosition", goods.getShelfPosition());
            result.put("inDate", goods.getInDate());
            result.put("outDate", goods.getOutDate());
            result.put("inStock", goods.isInStock());
            mapList.add(result);
        }

        return mapList;
    }

    public Goods editGoods(Goods goods) {
       return null;
    }

    public void removeGoods(int id) {
        Goods goods = goodsRepository.findById(id).orElse(null);
        if (goods != null) {
            goods.setOutDate(new Date());
            goods.setInStock(false);
            goodsRepository.save(goods);
        }
    }


}
