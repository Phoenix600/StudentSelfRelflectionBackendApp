package com.pranay.StudentSelfReflection.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.util.function.LongToDoubleFunction;

/**
 * File Name: Course.java
 * Entity: Course
 * Package: com.pranay.StudentSelfReflection.model
 * Author: pranayramteke
 * Date: 21/04/25
 * Description:
 */

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Course
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long courseId;
	
	private String title;
	private String description;;
	private Long duration;
	private String author;
	private String companyName;
	private Integer price;
	
}
