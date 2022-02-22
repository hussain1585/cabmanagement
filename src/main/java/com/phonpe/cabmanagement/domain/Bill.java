package com.phonpe.cabmanagement.domain;

import com.phonpe.cabmanagement.enums.PaymentType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity(name = "bill")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Bill
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bill_id")
    private Long billId;

    private BigDecimal amount;
    private PaymentType paymentType;
    private BigDecimal fareSuggested;
    private BigDecimal farePaid;

}
