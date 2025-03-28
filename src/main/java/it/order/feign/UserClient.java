package it.order.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import it.order.model.User;

@FeignClient(name = "user-service") //user-service deve essere il nome dell'application.properties del servizio da chiamare registrato su Eureka
public interface UserClient {

    @GetMapping("/users/{id}")
    User getUserById(@PathVariable Long id);
}