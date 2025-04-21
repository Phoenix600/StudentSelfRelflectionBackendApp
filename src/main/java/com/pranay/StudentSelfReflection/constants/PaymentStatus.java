package com.pranay.StudentSelfReflection.constants;

/**
 * File Name: PaymentStatus.java
 * Entity: PaymentStatus
 * Package: com.pranay.StudentSelfReflection.constants
 * Author: pranayramteke
 * Date: 29/04/25
 * Description:
 */

public enum PaymentStatus
{
	PENDING("PENDING"),
	PAID("PAID"),
	PARTIALLY_PAID("PARTIALLY_PAID"),
	OVERDUE("OVERDUE");
	
	private final String sPaymentStatus;
	
	private PaymentStatus(String sPaymentStatus)
	{
		this.sPaymentStatus = sPaymentStatus;
	}
	
	public String getSPaymentStatus()
	{
		return this.sPaymentStatus;
	}
}
