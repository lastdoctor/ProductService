package com.appdeveloperblog.estore.productservice.command.rest;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CreateProductRestDto {
    private String title;
    private BigDecimal price;
    private Integer quantity;
}
