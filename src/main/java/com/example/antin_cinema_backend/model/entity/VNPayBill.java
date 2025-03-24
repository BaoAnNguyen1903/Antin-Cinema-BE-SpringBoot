package com.example.antin_cinema_backend.model.entity;

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
public class VNPayBill {
    private String vnpTxnRef; // vnp_TxnRef
    private float vnpAmount; // vnp_Amount
    private String vnpPayDate; // vnp_PayDate
    private String vnpTransactionStatus; // vnp_TransactionStatus
    private Booking booking;
}
