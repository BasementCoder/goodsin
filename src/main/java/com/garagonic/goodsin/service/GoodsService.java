package com.garagonic.goodsin.service;

import com.garagonic.goodsin.repository.Goods;
import com.garagonic.goodsin.repository.GoodsRepository;
import com.garagonic.goodsin.tools.Fn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
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

    public void updateGoods(Goods updateDataGoods) {
        if (updateDataGoods != null) {
            Goods goods = goodsRepository.getOne(updateDataGoods.getId());
            goods.setPo( updateDataGoods.getPo());
            goods.setWo(updateDataGoods.getWo());
            goods.setSo(updateDataGoods.getSo());
            goods.setCustomer(updateDataGoods.getCustomer());
            goods.setTitle(updateDataGoods.getTitle());
            goods.setRack(updateDataGoods.getRack());
            goods.setShelf(updateDataGoods.getShelf());
            goods.setShelfPosition(updateDataGoods.getShelfPosition());

            goodsRepository.save(goods);
        }
    }

    public List<Goods> getGoodsList(Goods goods) {
        Goods searchData = new Goods();
        ExampleMatcher exampleMatcher = ExampleMatcher.matching().withIncludeNullValues().withIgnorePaths("id", "rack", "shelf", "shelfPosition", "wo", "so", "comment", "inDate", "outDate", "customer", "title", "barcode", "inStock" );

        if (goods != null) {
            if (goods.getPo() != 0) {
                searchData.setPo(goods.getPo());
            } else {
                exampleMatcher = exampleMatcher.withIgnorePaths("po");
            }
//        if (goods.getWo() != 0) {
//            searchResults = findByWO(wo, searchResults);
//        }
//        if (goods.getSo() != 0) {
//            searchResults = findBySO(so, searchResults);
//        }
//        if (Fn.isStringPopulated(goods.getCustomer())) {
//            searchResults = findByCustomer(customer, searchResults);
//        }
//        if (Fn.isStringPopulated(goods.getTitle())) {
//            searchResults = findByTitle(title, searchResults);
//        }
//        if (Fn.isStringPopulated(goods.getLocation())) {
//            searchResults = findByLocation(location, searchResults);
//        }

//        if (onlyCurrentGoods) {
//            searchResults = findCurrentGoods(searchResults);
//        }
        }
        return goodsRepository.findAll(Example.of( searchData, exampleMatcher));
    }

    public Goods getGoods(int id) {
       return goodsRepository.findById(id).orElse(null);
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
