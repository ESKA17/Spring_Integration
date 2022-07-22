package com.example.order;

import lombok.AllArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@AllArgsConstructor
public class OrderRequest {
    @NotNull
    @Min(1/100L)
    private BigDecimal amount;
    @Email
    private String email;
}
