package com.appdeveloperblog.estore.productservice.core.data;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepositoty extends JpaRepository<ProductEntity, String> {
    ProductEntity findByProductId(String productId);

    ProductEntity findByProductIdOrTitle(String productId, String title);
}
