package com.example.order;

import lombok.*;

import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
@Builder
@Getter
@Setter
@ToString
public class OrderModel {
    private BigDecimal amount;
    private String email;
    private Boolean payed;
}
