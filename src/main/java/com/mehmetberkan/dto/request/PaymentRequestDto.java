package com.mehmetberkan.dto.request;



import java.math.BigDecimal;

public record PaymentRequestDto(
        Long senderId,
        Long recipientId,
        BigDecimal amount,
        Long categoryId
) {
}
