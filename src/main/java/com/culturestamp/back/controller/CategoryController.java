package com.culturestamp.back.controller;

import com.culturestamp.back.controller.request.CategoryRequest;
import com.culturestamp.back.dto.CategoryResponse;
import com.culturestamp.back.entity.Category;
import com.culturestamp.back.service.CategoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/category")
public class CategoryController {

	private final CategoryService service;

	@PostMapping()
	public CategoryResponse categoryAdd(@RequestBody CategoryRequest categoryRequest){
		Category category = service.addCategory(categoryRequest);
		return new CategoryResponse(category);
	}

	@GetMapping("/{categoryId}")
	public CategoryResponse categoryDetails(@PathVariable(name = "categoryId") Long categoryId) throws Exception {
		Category category =  service.findCategory(categoryId);
		return new CategoryResponse(category);
	}

	@DeleteMapping("/{categoryId}")
	public void categoryRemove(@PathVariable Long categoryId){
		service.removeCategory(categoryId);
	}

	@PatchMapping("/{categoryId}")
	public CategoryResponse categoryModify(@PathVariable Long categoryId ,@RequestBody CategoryRequest categoryRequest) throws Exception {
		final Category category =  service.modifyCategory(categoryId,categoryRequest);
		return new CategoryResponse(category);
	}


}
