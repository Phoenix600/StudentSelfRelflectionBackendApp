package com.pranay.StudentSelfReflection.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

/**
 * File Name: ApplicationUser.java
 * Entity: ApplicationUser
 * Package: com.pranay.StudentSelfReflection.model
 * Author: pranayramteke
 * Date: 21/04/25
 * Description:
 */

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter @ToString
@Entity
public class ApplicationUser
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long applicationUserId;
	
	private String username;
	private String email;
	private String pwd;
}
