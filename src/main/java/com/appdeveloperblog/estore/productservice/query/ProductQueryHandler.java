package com.appdeveloperblog.estore.productservice.query;

import com.appdeveloperblog.estore.productservice.core.data.ProductEntity;
import com.appdeveloperblog.estore.productservice.core.data.ProductRepository;
import com.appdeveloperblog.estore.productservice.query.rest.ProductRestModel;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductQueryHandler {
    private final ProductRepository productRepository;

    public ProductQueryHandler(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @QueryHandler
    public List<ProductRestModel> findProducts(FindProductsQuery query) {
        List<ProductEntity> productEntities = productRepository.findAll();
        List<ProductRestModel> productRestModels = new ArrayList<>();
        productEntities.stream().forEach(productEntity -> {
                    ProductRestModel productRestModel = new ProductRestModel();
                    BeanUtils.copyProperties(productEntity, productRestModel);
                    productRestModels.add(productRestModel);
                }
        );
        return productRestModels;
    }
}
