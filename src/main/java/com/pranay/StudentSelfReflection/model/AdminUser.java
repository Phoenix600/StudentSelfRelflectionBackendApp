package com.pranay.StudentSelfReflection.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * File Name: AdminUser.java
 * Entity: AdminUser
 * Package: com.pranay.StudentSelfReflection.model
 * Author: pranayramteke
 * Date: 08/05/25
 * Description:
 */

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AdminUser extends Users{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long studentId;
	
}
