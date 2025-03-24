package com.example.antin_cinema_backend.model.entity;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Discount {
    private int discountId;
    private User user;
    private String discountCode;
    private String discountDescription;
    private float discountPercentage;
    private int numberOfDiscount;
    private int totalUse;
    private LocalDate startDate;
    private LocalDate endDate;
    private float minAmount;
    private float maxAmount;
    private int status;
}
