package com.pranay.StudentSelfReflection.model;

import com.pranay.StudentSelfReflection.constants.ModeOfPayment;
import com.pranay.StudentSelfReflection.constants.PaymentStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

/**
 * File Name: FeePayment.java
 * Entity: FeePayment
 * Package: com.pranay.StudentSelfReflection.model
 * Author: pranayramteke
 * Date: 29/04/25
 * Description:
 */


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class FeePayment extends BaseEntity
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long feePaymentId;
	
	private Double amountPaid;
	
	private Double totalFee;
	
	private Boolean isDiscountApplied;
	
	private Double discountAmount;
	
	private Double finalAmountDue;
	
	private LocalDate paymentDate;
	
	@Enumerated(EnumType.STRING)
	private ModeOfPayment eModeOfPayment;
	
	@Enumerated(EnumType.STRING)
	private PaymentStatus ePaymentStatus;
	
	private Integer installmentNumber;
	
	private Integer nAssignedInstallmentNumber;
	
	private String remarks;

}
