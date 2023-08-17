package com.shoparsenal.shoparsenal.DTOs;

import com.shoparsenal.shoparsenal.model.LocalUser;
import lombok.*;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AddressDTO {
    private String address1;
    private String city;
    private String country;
    private LocalUser user;
}
