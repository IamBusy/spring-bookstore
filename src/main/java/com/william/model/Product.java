package com.william.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by william on 17/3/24.
 */
@Data
@Document(indexName = "bookstore",type="product")
public class Product  implements Serializable {
    @Id
    protected String id;
    protected String cover;
    protected String name;
    protected String publisher;
    protected String author;
    protected String categoryId;
    protected BigDecimal price;
    protected String introduction;


    protected Category category;
}
