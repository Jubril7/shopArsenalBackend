package com.shoparsenal.shoparsenal.DTOs;

import com.shoparsenal.shoparsenal.model.Product;
import com.shoparsenal.shoparsenal.model.Order;
import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserOrderQuantitiesDTO {
    private Product product;
    private Integer quantity;
    private Order order;
}
