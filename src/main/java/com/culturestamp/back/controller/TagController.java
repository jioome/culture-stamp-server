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
import com.culturestamp.back.controller.request.TagRequest;
import com.culturestamp.back.controller.request.TodoRequest;
import com.culturestamp.back.dto.CategoryResponse;
import com.culturestamp.back.dto.CommonResponse;
import com.culturestamp.back.dto.TagResponse;
import com.culturestamp.back.dto.TodoResponse;
import com.culturestamp.back.entity.Category;
import com.culturestamp.back.entity.Tag;
import com.culturestamp.back.entity.Todo;
import com.culturestamp.back.service.CategoryService;
import com.culturestamp.back.service.TagService;
import com.culturestamp.back.service.TodoService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/tag")
public class TagController {
	private final TagService service;

	@PostMapping()
	public ResponseEntity<?> TagAdd(@RequestBody TagRequest tagRequest){

		TagResponse tagResponse = service.addTag(tagRequest);
		return ResponseEntity.ok(new CommonResponse<>("SUCCESS",tagResponse));
	}

	@GetMapping()
	public ResponseEntity<List> todoAll() {
		return ResponseEntity.ok(service.findAllTag());
	}

	@GetMapping("/{tagId}")
	public ResponseEntity<?> tagDetails(@PathVariable(name = "tagId") Long tagId) throws Exception {
		// return ResponseEntity.ok(service.findTodo(todoId));
		TagResponse tagResponse = service.findTag(tagId);
		return ResponseEntity.ok(new CommonResponse<>("SUCCESS",tagResponse));
	}

	@DeleteMapping("/{tagId}")
	public ResponseEntity<Void> tagRemove(@PathVariable Long tagId ){
		service.removeTag(tagId);
		return ResponseEntity.ok().build();
	}

	@PatchMapping("/{tagId}")
	public ResponseEntity<TagResponse> tagModify(@PathVariable Long tagId ,@RequestBody TagRequest tagRequest) throws Exception {
		return ResponseEntity.ok(service.modifyTag(tagId,tagRequest));
	}


}
