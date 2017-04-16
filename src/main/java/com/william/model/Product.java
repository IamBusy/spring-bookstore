package com.william.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by william on 17/3/24.
 */
@Data
public class Product  implements Serializable {
    @Id
    private String id;
    private String cover;
    private String name;
    private String publisher;
    private String author;
    private String categoryId;
    private BigDecimal price;


    private Category category;
}
