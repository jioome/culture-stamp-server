package com.culturestamp.back.dto;

import java.time.LocalDateTime;

import javax.persistence.Column;

import com.culturestamp.back.entity.Category;
import com.culturestamp.back.entity.Todo;
import com.culturestamp.back.entity.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@Builder
public class TodoResponse {
	private final Long todoId;
	private final String content;
	private final LocalDateTime date;
	private final User user;
	private final int doneFlag;

	@Builder
	public TodoResponse(Todo todo) {
		this.todoId = todo.getId();
		this.content = todo.getContent();
		this.date = todo.getDate();
		this.doneFlag = todo.getDoneFlag();
		this.user = todo.getUser();
	}


}
