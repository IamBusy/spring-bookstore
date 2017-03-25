package com.william.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.List;

/**
 * Created by william on 17/3/24.
 */
@Data
public class Category {
    @Id
    private String id;
    private String name;
    private Integer order;
}
