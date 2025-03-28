package it.order.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderRequest {
    private String productName;
    private Double price;
    private Integer quantity;
    private Long userId;  // ID dello User
}