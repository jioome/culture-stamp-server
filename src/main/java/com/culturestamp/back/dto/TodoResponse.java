package com.culturestamp.back.dto;

import com.culturestamp.back.entity.Todo;
import com.culturestamp.back.entity.User;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class TodoResponse {
	private final Long id;
	private final String content;
	private final User user;
	private final int doneFlag;

	public TodoResponse(Todo todo) {
		this.id = todo.getId();
		this.content = todo.getContent();
		this.doneFlag = todo.getDoneFlag();
		this.user = todo.getUser();
	}

	@Builder
	public TodoResponse(Long id, String content,  User user, int doneFlag) {
		this.id = id;
		this.content = content;
		this.doneFlag = doneFlag;
		this.user = user;
	}

}
