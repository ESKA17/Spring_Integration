package com.example.order;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@AllArgsConstructor
@Getter
@Setter
public class OrderRequest {
    @NotNull
    @Min(1/100L)
    private BigDecimal amount;
    @Email
    private String email;
}
