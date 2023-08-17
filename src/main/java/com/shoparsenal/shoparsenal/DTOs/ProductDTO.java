package com.shoparsenal.shoparsenal.DTOs;

import com.shoparsenal.shoparsenal.model.Inventory;
import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDTO {
    private String productName;
    private String productDescription;
    private Double price;
    private Inventory inventory;
}
