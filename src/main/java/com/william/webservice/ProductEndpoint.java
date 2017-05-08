package com.william.webservice;

import com.william.repository.ProductRepository;
import io.spring.guides.gs_producing_web_service.GetProductRequest;
import io.spring.guides.gs_producing_web_service.GetProductResponse;
import io.spring.guides.gs_producing_web_service.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

/**
 * Created by william on 08/05/2017.
 */

@Endpoint
public class ProductEndpoint {
    private static final String NAMESPACE_URI = "http://spring.io/guides/gs-producing-web-service";

    //private ProductService productService;
    private ProductRepository product;

    @Autowired
    public void ProductEndpoint(ProductRepository product) {
        this.product = product;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getProductRequest")
    @ResponsePayload
    public GetProductResponse getCountry(@RequestPayload GetProductRequest request) {
        GetProductResponse response = new GetProductResponse();
        com.william.model.Product product = this.product.findOne(request.getId());
        Product wspord = new Product();
        if(product != null) {
            wspord.setId(product.getId());
            wspord.setName(product.getName());
            wspord.setAuthor(product.getAuthor());
            wspord.setCategoryId(product.getCategoryId());
            wspord.setPublisher(product.getPublisher());
            wspord.setCover(product.getCover());
            wspord.setPrice(product.getPrice());
        }
        response.setProduct(wspord);

        return response;
    }
}
