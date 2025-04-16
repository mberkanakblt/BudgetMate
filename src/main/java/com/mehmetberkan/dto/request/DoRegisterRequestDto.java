package com.mehmetberkan.dto.request;


import java.math.BigDecimal;

public record DoRegisterRequestDto(
        String name,
        String password,
        String rePassword,
        String email,
        String phone,
        String address,
        BigDecimal balance
) {
}
