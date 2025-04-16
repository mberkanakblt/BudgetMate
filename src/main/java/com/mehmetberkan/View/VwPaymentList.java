package com.mehmetberkan.View;

import com.mehmetberkan.entity.Category;
import com.mehmetberkan.entity.User;
import com.mehmetberkan.utility.PaymentStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;
@Getter
@AllArgsConstructor
public class VwPaymentList {
    Long id;
    User sender;
    User recipient;
    BigDecimal amount;
    String time;
    PaymentStatus status;
    Category category;
}
