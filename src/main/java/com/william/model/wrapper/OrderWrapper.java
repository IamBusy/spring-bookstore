package com.william.model.wrapper;

import com.william.model.OrderProduct;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by william on 17/04/2017.
 */
@Data
public class OrderWrapper {
    private List<OrderProductWrapper> products;


    public List<OrderProduct> getOrderProducts() {
        List<OrderProduct> res = new ArrayList<>();
        for(OrderProductWrapper productWrapper:products) {
            OrderProduct pd = new OrderProduct();
            pd.setId(productWrapper.getId());
            pd.setQuantity(productWrapper.getQuantity());
            res.add(pd);
        }
        return res;

    }
}
