package com.culturestamp.back.service.impl;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.stereotype.Service;

import com.culturestamp.back.controller.request.TodoRequest;
import com.culturestamp.back.dto.TodoResponse;
import com.culturestamp.back.entity.Todo;
import com.culturestamp.back.repository.TodoRepository;
import com.culturestamp.back.service.TodoService;

import lombok.*;

@Service
@RequiredArgsConstructor
public class TodoServiceImpl implements TodoService {
	final private TodoRepository todoRepository;


	@Override
	public TodoResponse addTodo(TodoRequest todoRequest){
		Todo todo = todoRepository.save(todoRequest.toEntity(todoRequest));
		return new TodoResponse(todo);
	}

	@Override
	public List<Todo> findAllTodo(){
		return todoRepository.findAll();
	}

	@Override
	public TodoResponse findTodo(Long todoId)  {
		Todo todo =  todoRepository.findById(todoId).orElseThrow(NullPointerException::new);
		return new TodoResponse(todo);
	}

	@Override
	public void removeTodo(Long todoId){
		todoRepository.deleteById(todoId);
	}

	@Override
	public TodoResponse modifyTodo(Long todoId, TodoRequest todoRequest) throws Exception {
		Optional<Todo> optionalTodo = todoRepository.findById(todoId);
		if (optionalTodo.isEmpty()) {
			throw new EntityNotFoundException(
				"Todo not present in the database"
			);
		}
		Todo modifyTodo= optionalTodo.get();
		if(todoRequest.getContent()!=null)modifyTodo.setContent(todoRequest.getContent());
		if(todoRequest.getDate()!=null)modifyTodo.setDate(todoRequest.getDate());
		Todo todo = todoRepository.save(modifyTodo);
		return new TodoResponse(todo);
	}


}