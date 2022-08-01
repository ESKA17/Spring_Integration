package com.example.payment;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@Slf4j
@RequestMapping("/order")
@RequiredArgsConstructor
public class PaymentController {
    private final PaymentService paymentService;
    @PostMapping()
    public ResponseEntity<String> createPayment(@RequestBody @Valid PaymentRequest paymentRequest) {
        paymentService.createPaymentRequest(paymentRequest);
        return ResponseEntity.ok("Payment request was created");
    }
}
