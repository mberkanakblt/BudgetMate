package com.mehmetberkan.controller;


import com.mehmetberkan.dto.request.PaymentRequestDto;
import com.mehmetberkan.dto.response.BaseResponse;
import com.mehmetberkan.entity.Payment;
import com.mehmetberkan.service.PaymentService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.mehmetberkan.config.RestApis.*;



@RestController
@RequestMapping(PAYMENT)
@RequiredArgsConstructor
@CrossOrigin("*")
@SecurityRequirement(name = "bearerAuth")
public class PaymentController {
    private final PaymentService paymentService;

    @PostMapping(MAKE_PAYMENT)
    public ResponseEntity<BaseResponse<Boolean>> sendPayment(@RequestBody PaymentRequestDto dto){
        paymentService.sendPayment(dto);
        return  ResponseEntity.ok(BaseResponse.<Boolean>builder()
                        .code(200)
                        .message("Payment sent")
                        .data(true)
                .build());
    }
    @GetMapping(GET_PAYMENT)
    public ResponseEntity<BaseResponse<List<Payment>>> getAllPayment(){
        return ResponseEntity.ok(BaseResponse.<List<Payment>>builder()
                        .code(200)
                        .message("Payment list")
                        .data(paymentService.getPaymentList())
                .build());

    }


}
