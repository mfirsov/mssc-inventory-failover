package com.mfirsov.msscinventoryfailover.config;

import com.mfirsov.msscinventoryfailover.controller.InventoryController;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;

import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class RouterConfig {

    public RouterFunction inventoryRoute(InventoryController inventoryController) {
        return route(RequestPredicates.GET("/inventory-failover").and(accept(MediaType.APPLICATION_STREAM_JSON)),
                inventoryController::inventoryList);
    }

}
