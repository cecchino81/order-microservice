package it.order.service;

import org.springframework.stereotype.Service;

import it.order.dto.OrderRequest;
import it.order.entity.Order;
import it.order.feign.UserClient;
import it.order.model.User;
import it.order.repository.OrderRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final UserClient userClient;  // Chiamata a user-service

    public Order createOrder(OrderRequest orderRequest) {
        // Chiamata a user-service per ottenere l'utente
        User user = userClient.getUserById(orderRequest.getUserId());

        if (user == null) {
            throw new RuntimeException("User not found");
        }

        Order order = new Order();
        order.setProductName(orderRequest.getProductName());
        order.setPrice(orderRequest.getPrice());
        order.setQuantity(orderRequest.getQuantity());
        order.setUserId(user.getId());

        return orderRepository.save(order);
    }
}