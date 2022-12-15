package com.appdeveloperblog.estore.productservice.command.rest;

import com.appdeveloperblog.estore.productservice.command.CreateProductCommand;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("/products")
public class ProductCommandController {

    private final Environment env;
    private final CommandGateway commandGateway;

    @Autowired
    public ProductCommandController(Environment env, CommandGateway commandGateway) {
        this.env = env;
        this.commandGateway = commandGateway;
    }

    @PostMapping
    public String createProduct(@Valid @RequestBody CreateProductRestDto createProductRestDto) {
        CreateProductCommand createProductCommand = CreateProductCommand.builder()
                .productId(UUID.randomUUID().toString())
                .price(createProductRestDto.getPrice())
                .quantity(createProductRestDto.getQuantity())
                .title(createProductRestDto.getTitle())
                .build();

        String result;
        try {
            result = commandGateway.sendAndWait(createProductCommand);
        } catch (Exception e) {
            result = e.getLocalizedMessage();
        }

        return result;
    }
}
