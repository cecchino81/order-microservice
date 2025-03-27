package it.order.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.order.feign.UserClient;
import it.order.model.User;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final UserClient userClient;

    public OrderController(UserClient userClient) {
        this.userClient = userClient;
    }

    @GetMapping("/{userId}")
    public String getOrderForUser(@PathVariable Long userId) {
        User user = userClient.getUserById(userId);
        return "Ordine creato per l'utente: " + user.getNome() + " con email " + user.getEmail();
    }
}