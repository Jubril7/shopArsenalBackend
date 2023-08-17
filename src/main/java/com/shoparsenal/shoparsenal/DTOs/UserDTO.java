package com.shoparsenal.shoparsenal.DTOs;

import jakarta.validation.constraints.*;
import lombok.*;





@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDTO {
    @NotNull
    @NotBlank
    @Size(max = 255, min = 3)
    private String username;
    @NotNull
    @NotBlank
    @Size(max = 32, min = 6)
    //regex for pattern of password required
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{6,}$")
    private String password;
    @NotNull
    @NotBlank
    @Email
    private String email;
    @NotNull
    @NotBlank
    private String firstName;
    @NotNull
    @NotBlank
    private String lastName;
//    private Set<Address> addresses;
}
