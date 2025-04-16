package com.mehmetberkan.repository;


import com.mehmetberkan.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PaymentRepository extends JpaRepository<Payment, Long> {

}
