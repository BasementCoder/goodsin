package com.garagonic.goodsin.service;

import com.garagonic.goodsin.repository.Goods;
import com.garagonic.goodsin.repository.GoodsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public List<Map> getGoods(){
        List<Goods> all = goodsRepository.findAll();
        List<Map> mapList = new ArrayList<>();
        for (Goods goods : all) {
            Map<String, Object> result = new HashMap<>();
            result.put("po", goods.getPO());
            result.put("wo", goods.getWO());
            result.put("so", goods.getSO());
            mapList.add(result);
        }

          return mapList;
    }


}
