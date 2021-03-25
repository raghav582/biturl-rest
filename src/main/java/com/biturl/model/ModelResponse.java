package com.biturl.model;

import java.util.ArrayList;
import java.util.List;

public class ModelResponse {

	private String response;
	private Integer id;
	private List<String> messages = new ArrayList<>();
	private Boolean success;

	private ModelResponse(final String response, final Boolean success) {
		this.id = null;
		this.response = response;
		this.success = success;
	}

	private ModelResponse(final String response, final Boolean success, final Integer id) {
		this.id = id;
		this.response = response;
		this.success = success;
	}

	public static ModelResponse ok() {
		return new ModelResponse("OK", true);
	}

	public static ModelResponse ok(final Integer id) {
		return new ModelResponse("OK", true, id);
	}

	public static ModelResponse failed() {
		return new ModelResponse("FAILED", false);
	}

	public String getResponse() {
		return response;
	}

	public void setResponse(final String response) {
		this.response = response;
	}

	public Integer getId() {
		return id;
	}

	public void setId(final Integer id) {
		this.id = id;
	}

	public List<String> getMessages() {
		return messages;
	}

	public void setMessages(final List<String> messages) {
		this.messages = messages;
	}

	public Boolean getSuccess() {
		return success;
	}

	public void setSuccess(final Boolean success) {
		this.success = success;
	}
}
