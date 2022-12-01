package com.culturestamp.back.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.culturestamp.back.dto.CategoryResponse;
import com.culturestamp.back.entity.Category;
import com.culturestamp.back.service.CategoryService;
import com.culturestamp.back.service.impl.CategoryServiceImpl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/category")
public class CategoryController {
	//
	private final CategoryService service;

	@PostMapping()
	public ResponseEntity<CategoryResponse> categoryAdd(@RequestBody CategoryRequest categoryRequest){
		return ResponseEntity.ok( service.addCategory(categoryRequest) );
	}

	@GetMapping()
	public List<CategoryResponse> categoryAll() {
		return service.findAllCategory().stream()
			.map(CategoryResponse::fromEntity).collect(Collectors.toList());
	}
	@GetMapping("/{categoryId}")
	public ResponseEntity<CategoryResponse>  categoryDetails(@PathVariable(name = "categoryId") Long categoryId) throws Exception {
		return ResponseEntity.ok().body( service.findCategory(categoryId) );
	}

	@DeleteMapping("/{categoryId}")
	public void categoryRemove(@PathVariable Long categoryId){
		service.removeCategory(categoryId);
	}

	@PatchMapping("/{categoryId}")
	public ResponseEntity<CategoryResponse>  categoryModify(@PathVariable Long categoryId ,@RequestBody CategoryRequest categoryRequest) throws Exception {
		return ResponseEntity.ok( service.modifyCategory(categoryId, categoryRequest) );
	}


}
