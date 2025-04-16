package com.mehmetberkan.dto.request;


import com.mehmetberkan.entity.Category;

import java.math.BigDecimal;

public record PaymentRequestDto(
        Long senderId,
        Long recipientId,
        BigDecimal amount,
        Long categoryId
) {
}
