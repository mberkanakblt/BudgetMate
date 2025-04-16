package com.mehmetberkan.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "tbluser")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    String password;
    String rePassword;
    String email;
    String phone;
    String address;
    BigDecimal balance;

    @OneToMany
    List<Payment> sentPayments;

    @OneToMany
    List<Payment> receivedPayments;
}
