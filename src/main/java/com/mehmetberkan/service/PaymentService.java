package com.mehmetberkan.service;

import com.mehmetberkan.dto.request.PaymentRequestDto;
import com.mehmetberkan.entity.Payment;
import com.mehmetberkan.entity.User;
import com.mehmetberkan.repository.PaymentRepository;
import com.mehmetberkan.repository.UserRepository;
import com.mehmetberkan.utility.PaymentStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;


@Service
@RequiredArgsConstructor
public class PaymentService {
    public final PaymentRepository paymentRepository;
    public final UserRepository userRepository;


    public void sendPayment(PaymentRequestDto dto) {
        User sender = userRepository.findById(dto.senderId())
                .orElseThrow(() -> new RuntimeException("Sender not found"));
        User recipient = userRepository.findById(dto.recipientId())
                .orElseThrow(() -> new RuntimeException("Recipient not found"));

        if (sender.getBalance().compareTo(dto.amount()) < 0) {
            throw new RuntimeException("Insufficient balance");
        }
        sender.setBalance(sender.getBalance().subtract(dto.amount()));
        recipient.setBalance(recipient.getBalance().add(dto.amount()));

        Payment payment = Payment.builder()
                .sender(sender)
                .recipient(recipient)
                .amount(dto.amount())
                .time(LocalDateTime.now().toString())
                .status(PaymentStatus.PENDING)
                .build();

        paymentRepository.save(payment);
        
    }


    public List<Payment> getPaymentList() {
        List<Payment> paymentLists = paymentRepository.findAll();
        return paymentLists;
    }
}
