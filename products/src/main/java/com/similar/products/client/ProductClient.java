package com.similar.products.client;

import com.similar.products.model.ProductModel;
import com.similar.products.model.SimilarModel;
import com.similar.products.util.ConfigUtility;
import com.similar.products.util.Properties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
@Slf4j
public class ProductClient {

    @Autowired
    private ConfigUtility configUtil;

    public Mono<ProductModel> getProduct(String id){

        log.info("Calling getProduct id: {}", id);
        WebClient client = WebClient.create(configUtil.getProperty(Properties.BASE_URL.getKey()));
        return client.get()
                .uri("/{id}", id)
                .retrieve()
                .bodyToMono(ProductModel.class).log("Product fetched")
                ;
    }

    public Flux<SimilarModel> getSimilarProducts(String id){

        log.info("Calling getSimilarProducts id: {}", id);
        WebClient client = WebClient.create( configUtil.getProperty(Properties.BASE_URL.getKey()));
        return client.get()
                .uri("/{id}/similarids", id)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToFlux(SimilarModel.class)
                .log("Product fetched")
                ;
    }

    public Flux<ProductModel> fetchProducts(String id) {

        log.info("Calling fetchProducts ids: {}", id);

        List<ProductModel> productModels = new ArrayList<>();
        Flux<String> flux = Flux.just(getSimilarProducts(id).toString());

        return this.getSimilarProducts(id)
                .flatMap(
                        returnedItem -> {
                            log.info("returnedItem: {}", returnedItem);
                            return   Flux.fromIterable(Arrays.asList(returnedItem.getId()))
                                    .flatMap( m -> {
                                        log.info("mapInner: {}", m);
                                        return this.getProduct(m.toString());
                                    });

                        }
                );
    }


}
