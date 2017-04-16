package com.william.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by william on 17/3/24.
 */
@Data
public class Order implements Serializable{
    @Id
    private String id;
    private BigDecimal total;
    private Date createdAt;
    private User user;
    private List<OrderProduct> products;

}
