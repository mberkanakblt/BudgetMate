package com.mehmetberkan.entity;

import com.mehmetberkan.utility.PaymentStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "tblpayment")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @ManyToOne
    User sender;
    @ManyToOne
    User recipient;
    BigDecimal amount;
    String time;
    @Enumerated(EnumType.STRING)
    PaymentStatus status;
    Long categoryId;

}
