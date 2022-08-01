package com.example.payment;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@AllArgsConstructor
@Getter
@Setter
public class PaymentRequest {
    @NotNull
    private Long orderID;
    @NotNull
    @Size(min = 16, max = 16)
    private String cardNumber;
}
