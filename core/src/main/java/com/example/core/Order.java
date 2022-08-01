package com.example.core;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(name = "order_table")
public class Order {
    @Id
    private Long id;
    @NotNull
    @Min(1/100L)
    private BigDecimal amount;
    @Email
    private String email;
    @NotNull
    private Boolean payed;
    private String cardNumber;

}
