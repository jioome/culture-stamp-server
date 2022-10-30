package com.culturestamp.back.service;

import com.culturestamp.back.controller.request.CategoryRequest;
import com.culturestamp.back.entity.Category;

public interface CategoryService {
	Category addCategory(CategoryRequest categoryRequest);
	Category findCategory(Long categoryId);
	void removeCategory(Long categoryId);
}
