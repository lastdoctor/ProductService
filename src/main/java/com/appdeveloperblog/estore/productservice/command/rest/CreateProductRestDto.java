package com.appdeveloperblog.estore.productservice.command.rest;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;

@Data
public class CreateProductRestDto {
    @NotBlank(message = "title is required")
    private String title;
    @Min(value = 1, message = "price cannot be lower than 1")
    private BigDecimal price;
    @Min(value = 1, message = "quantity cannot be lower than 1")
    @Max(value = 100, message = "quantity cannot be higher than 100")
    private Integer quantity;
}
