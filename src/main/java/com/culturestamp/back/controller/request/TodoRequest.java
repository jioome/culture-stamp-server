package com.culturestamp.back.controller.request;

import java.time.LocalDateTime;

import com.culturestamp.back.entity.Todo;
import com.culturestamp.back.entity.User;
import lombok.*;


@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class TodoRequest {
	private Long id;
	private User user;
	private String content;
	private LocalDateTime date;
	private int doneFlag;


	public Todo toEntity(TodoRequest todoRequest) {
		return Todo.builder()
			.id(todoRequest.id)
			.user(todoRequest.user)
			.content(todoRequest.content)
			.date(todoRequest.date)
			.doneFlag(todoRequest.doneFlag)
			.build();
	}
}
