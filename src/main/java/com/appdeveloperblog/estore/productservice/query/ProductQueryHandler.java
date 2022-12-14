package com.appdeveloperblog.estore.productservice.query;

import com.appdeveloperblog.estore.productservice.core.data.ProductEntity;
import com.appdeveloperblog.estore.productservice.core.data.ProductRepositoty;
import com.appdeveloperblog.estore.productservice.query.rest.ProductRestModel;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductQueryHandler {
    private final ProductRepositoty productRepositoty;

    public ProductQueryHandler(ProductRepositoty productRepositoty) {
        this.productRepositoty = productRepositoty;
    }

    @QueryHandler
    public List<ProductRestModel> findProducts(FindProductsQuery query) {
        List<ProductEntity> productEntities = productRepositoty.findAll();
        List<ProductRestModel> productRestModels = new ArrayList<>();
        productEntities.stream().forEach(productEntity -> {
                    ProductRestModel productRestModel = new ProductRestModel();
                    BeanUtils.copyProperties(productEntity, productRestModel);
                    productRestModels.add(productRestModel);
                }
        );
        System.out.println(productRestModels);
        return productRestModels;
    }
}
