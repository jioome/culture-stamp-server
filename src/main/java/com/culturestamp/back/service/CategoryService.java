package com.culturestamp.back.service;

import java.util.List;

import com.culturestamp.back.controller.request.CategoryRequest;
import com.culturestamp.back.entity.Category;

public interface CategoryService {
	Category addCategory(CategoryRequest categoryRequest);
	List<Category> findAllCategory();
	Category findCategory(Long categoryId);
	void removeCategory(Long categoryId);

	Category modifyCategory(Long categoryId, CategoryRequest categoryRequest) throws Exception;
}
