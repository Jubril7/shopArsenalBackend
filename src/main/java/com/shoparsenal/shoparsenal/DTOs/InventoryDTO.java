package com.shoparsenal.shoparsenal.DTOs;

import com.shoparsenal.shoparsenal.model.Product;
import lombok.*;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class InventoryDTO {
    private Product product;
    private Integer quantity;
}
