package com.garagonic.goodsin.service;

import com.garagonic.goodsin.common.ErrorCodes;
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
            throw new RuntimeException("Goods cannot be null. Please make sure that at least fields of " + "'Title'" + " and " + "'Location'" + " is filled");
        }
    }

    public void updateGoods(Goods updateDataGoods) {
        if (updateDataGoods != null) {
            Goods goods = goodsRepository.getOne(updateDataGoods.getId());
            goods.setPo(updateDataGoods.getPo());
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
        return getGoodsList(goods, false);
    }

    public List<Goods> getGoodsList(Goods goods, Boolean inStockOnly) {

        ExampleMatcher exampleMatcher = ExampleMatcher.matching().withIncludeNullValues().withIgnorePaths("id", "comment", "inDate", "outDate", "barcode");
        boolean filterAdded = false;
        if (goods != null) {

            if (goods.getPo() == 0) {
                exampleMatcher = exampleMatcher.withIgnorePaths("po");
            } else { filterAdded = true; }
            if (goods.getWo() == 0) {
                exampleMatcher = exampleMatcher.withIgnorePaths("wo");
            } else { filterAdded = true; }
            if (goods.getSo() == 0) {
                exampleMatcher = exampleMatcher.withIgnorePaths("so");
            } else { filterAdded = true; }
            if (Fn.isStringEmpty(goods.getCustomer())) {
                exampleMatcher = exampleMatcher.withIgnorePaths("customer");
            } else { filterAdded = true; }
            if (Fn.isStringEmpty(goods.getTitle())) {
                exampleMatcher = exampleMatcher.withIgnorePaths("title");
            } else { filterAdded = true; }
            if (Fn.isStringEmpty(goods.getRack())) {
                exampleMatcher = exampleMatcher.withIgnorePaths("rack");
            } else { filterAdded = true; }
            if (Fn.isStringEmpty(goods.getShelf())) {
                exampleMatcher = exampleMatcher.withIgnorePaths("shelf");
            } else { filterAdded = true; }
            if (goods.getShelfPosition() == 0) {
                exampleMatcher = exampleMatcher.withIgnorePaths("shelfPosition");
            } else { filterAdded = true; }

            if (inStockOnly != null && inStockOnly) {
                goods.setInStock(true);
            }
            else {
                exampleMatcher = exampleMatcher.withIgnorePaths("inStock");
            }
        }
        if (!filterAdded) {
            throw new RuntimeException(ErrorCodes.EMPTY_SEARCH);
        }

        return goodsRepository.findAll(Example.of(goods, exampleMatcher));
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
