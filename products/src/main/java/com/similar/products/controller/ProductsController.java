package com.similar.products.controller;

import com.similar.products.client.ProductClient;
import com.similar.products.model.ProductModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/product")
@ControllerAdvice
@Slf4j
public class ProductsController {

    @Autowired
    private ProductClient productClient;

    @GetMapping("/{productId}")
    public Mono<ResponseEntity<ProductModel>> getProductById(@PathVariable String productId){

        return productClient.getProduct(productId)
                .map(ResponseEntity::ok)
                .onErrorResume( error -> {
                    WebClientResponseException err = (WebClientResponseException) error;
                    if( err.getStatusCode() == HttpStatus.NOT_FOUND){
                        return Mono.just(ResponseEntity.notFound().build());
                    }
                    return Mono.error(err);
                })
                ;

    }

    @GetMapping(value = "/{productId}/similarids")
    public Flux<ProductModel> getSimilarIds(@PathVariable("productId") String productId){

        return productClient.fetchProducts(productId)
                .map(m -> m)
                .onErrorResume( error -> {
                    WebClientResponseException err = (WebClientResponseException) error;
                    if( err.getStatusCode() == HttpStatus.NOT_FOUND){
                        log.info("ERROR EMPTY");
                        return Mono.empty();
                    }
                    return Mono.error(err);
                });
    }

}
