package com.william.model;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;


/**
 * Created by william on 17/3/25.
 */
@Data
public class OrderProduct extends Product {
    public OrderProduct (){}

    public OrderProduct (Map<String,String> param){
        for(Map.Entry<String,String> item:param.entrySet()){
            if(item.getKey().equals("id")){
                this.setId(item.getValue());
            }else if(item.getKey().equals("quantity")){
                this.setQuantity(Integer.valueOf(item.getValue()));
            }
        }
    }

    public OrderProduct (Product product) {
        this.setId(product.getId());
        this.setAuthor(product.getAuthor());
        this.setCategory(product.getCategory());
        this.setCover(product.getCover());
        this.setName(product.getName());
        this.setPrice(product.getPrice());
        this.setPublisher(product.getPublisher());
    }

    protected Integer quantity;

    public Map<String,String> toMap() {
        Map<String,String> res = new HashMap<>();
        res.put("id",this.getId());
        res.put("quantity",String.valueOf(this.getQuantity()));
        return res;
    }
}
