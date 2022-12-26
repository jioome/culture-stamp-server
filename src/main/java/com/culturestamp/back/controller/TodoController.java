package com.culturestamp.back.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.culturestamp.back.controller.request.CategoryRequest;
import com.culturestamp.back.controller.request.TodoRequest;
import com.culturestamp.back.dto.CategoryResponse;
import com.culturestamp.back.dto.CommonResponse;
import com.culturestamp.back.dto.TodoResponse;
import com.culturestamp.back.entity.Category;
import com.culturestamp.back.entity.Todo;
import com.culturestamp.back.service.CategoryService;
import com.culturestamp.back.service.TodoService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/todo")
public class TodoController {
	private final TodoService service;

	@PostMapping()
	public ResponseEntity<?> todoAdd(@RequestBody TodoRequest todoRequest){

		TodoResponse todoResponse = service.addTodo(todoRequest);
		return ResponseEntity.ok(new CommonResponse<>("SUCCESS",todoResponse));
	}

	@GetMapping()
	public ResponseEntity<List> todoAll() {
		return ResponseEntity.ok(service.findAllTodo());
	}
	@GetMapping("/{todoId}")
	public ResponseEntity<?> todoDetails(@PathVariable(name = "todoId") Long todoId) throws Exception {
		// return ResponseEntity.ok(service.findTodo(todoId));
		TodoResponse todoResponse = service.findTodo(todoId);
		return ResponseEntity.ok(new CommonResponse<>("SUCCESS",todoResponse));
	}

	@DeleteMapping("/{todoId}")
	public ResponseEntity<Void> todoRemove(@PathVariable Long todoId ){
		service.removeTodo(todoId);
		return ResponseEntity.ok().build();
	}

	@PatchMapping("/{todoId}")
	public ResponseEntity<TodoResponse> todoModify(@PathVariable Long todoId ,@RequestBody TodoRequest todoRequest) throws Exception {
		return ResponseEntity.ok(service.modifyTodo(todoId,todoRequest));
	}


}
