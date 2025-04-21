package com.pranay.StudentSelfReflection.constants;

/**
 * File Name: TopicStatus.java
 * Entity: TopicStatus
 * Package: com.pranay.StudentSelfReflection.constants
 * Author: pranayramteke
 * Date: 29/04/25
 * Description:
 */

public enum TopicStatus
{
	NOT_STARTED("NOT_STARTED"),
	STARTED("STARTED"),
	SKIPPED("SKIPPED"),
	FINISHED("FINSIHED");
	
	private final String topicStatus;
	
	
	private TopicStatus(String topicStatus)
	{
		this.topicStatus = topicStatus;
	}
	
	public String getTopicStatus()
	{
		return this.topicStatus;
	}
	
}
