package com.pranay.StudentSelfReflection.model;

import com.pranay.StudentSelfReflection.constants.TopicStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * File Name: Topic.java
 * Entity: Topic
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
public class Topic extends BaseEntity
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long topicId;
	
	private String title;
	private String description;
	
	@Enumerated(EnumType.STRING)
	private TopicStatus eTopicStatus;
}
