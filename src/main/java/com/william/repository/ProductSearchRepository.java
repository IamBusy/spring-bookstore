package com.william.repository;

import com.william.model.Product;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * Created by william on 03/07/2017.
 */
public interface ProductSearchRepository extends ElasticsearchRepository<Product,String> {
}
