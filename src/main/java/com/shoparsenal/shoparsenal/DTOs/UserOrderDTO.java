package com.shoparsenal.shoparsenal.DTOs;

import com.shoparsenal.shoparsenal.model.Address;
import com.shoparsenal.shoparsenal.model.LocalUser;
import com.shoparsenal.shoparsenal.model.OrderItem;
import lombok.*;


import java.util.Set;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserOrderDTO {
    private LocalUser user;
    private Address address;
    private Set<OrderItem> quantities;
}
