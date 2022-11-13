package com.appdeveloperblog.estore.productservice.rest;

import com.appdeveloperblog.estore.productservice.commands.CreateProductCommand;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final Environment env;
    private final CommandGateway commandGateway;

    @Autowired
    public ProductController(Environment env, CommandGateway commandGateway) {
        this.env = env;
        this.commandGateway = commandGateway;
    }

    @GetMapping
    public String getProduct() {
        return "http get " + env.getProperty("local.server.port");
    }

    @PostMapping
    public String createProduct(@RequestBody CreateProductRestDto createProductRestDto) {
        CreateProductCommand createProductCommand = CreateProductCommand.builder()
                .productId(UUID.randomUUID().toString())
                .price(createProductRestDto.getPrice())
                .quantity(createProductRestDto.getQuantity())
                .title(createProductRestDto.getTitle())
                .build();
        return commandGateway.sendAndWait(createProductCommand);
    }

    @PutMapping
    public String updateProduct() {
        return "http put " + env.getProperty("local.server.port");
    }

    @DeleteMapping
    public String deleteProduct() {
        return "http delete " + env.getProperty("local.server.port");
    }
}
