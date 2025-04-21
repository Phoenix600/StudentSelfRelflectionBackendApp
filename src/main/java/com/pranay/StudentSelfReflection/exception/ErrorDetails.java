package com.pranay.StudentSelfReflection.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * File Name: ErrorDetails.java
 * Entity: ErrorDetails
 * Package: com.pranay.StudentSelfReflection.exception
 * Author: pranayramteke
 * Date: 29/04/25
 * Description:
 */

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ErrorDetails
{
	private LocalDateTime timestamp;
	private String message;
	private String path;
	private String errorCode;
}


