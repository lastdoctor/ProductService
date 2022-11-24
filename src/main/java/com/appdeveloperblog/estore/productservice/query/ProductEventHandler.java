package com.appdeveloperblog.estore.productservice.query;

import com.appdeveloperblog.estore.productservice.core.data.ProductEntity;
import com.appdeveloperblog.estore.productservice.core.data.ProductRepositoty;
import com.appdeveloperblog.estore.productservice.core.events.ProductCreatedEvent;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class ProductEventHandler {
    private final ProductRepositoty productRepositoty;

    public ProductEventHandler(ProductRepositoty productRepositoty) {
        this.productRepositoty = productRepositoty;
    }

    @EventHandler
    public void on(ProductCreatedEvent event) {
        ProductEntity productEntity = new ProductEntity();
        BeanUtils.copyProperties(event, productEntity);
        productRepositoty.save(productEntity);
    }
}
