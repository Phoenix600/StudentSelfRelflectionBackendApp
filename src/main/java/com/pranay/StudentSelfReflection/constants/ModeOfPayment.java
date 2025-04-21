package com.pranay.StudentSelfReflection.constants;

/**
 * File Name: ModeOfPayment.java
 * Entity: ModeOfPayment
 * Package: com.pranay.StudentSelfReflection.constants
 * Author: pranayramteke
 * Date: 29/04/25
 * Description:
 */

public enum ModeOfPayment
{
	CASH("CASH"),
	UPI("UPI"),
	CARD("CARD"),
	BANK_TRANSFER("BANK_TRANSFER");
	
	private final String nModeOfPayment;
	
	private ModeOfPayment(String nModeOfPayment)
	{
		this.nModeOfPayment = nModeOfPayment;
	}
	public String getNModeOfPayment()
	{
		return this.nModeOfPayment;
	}
	
	
}
