/*
 * 
 */
package com.maglietta.user.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

/**
 * Service response to return messages.
 * 
 * @author Subha
 *
 */
@JsonRootName(value = "message")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MessageResponse {

	/**
	 * The message.
	 */
	@JsonProperty
	private String message;

	/**
	 * Instantiates a new response.
	 */
	public MessageResponse() {
	}

	/**
	 * Instantiates a new message response.
	 *
	 * @param message the message
	 */
	public MessageResponse(String message) {
		this.message = message;
	}
	/**
	 * Gets the success message.
	 *
	 * @return the success message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * Sets the success message.
	 *
	 * @param message the new message
	 */
	public void setMessage(String message) {
		this.message = message;
	}

}