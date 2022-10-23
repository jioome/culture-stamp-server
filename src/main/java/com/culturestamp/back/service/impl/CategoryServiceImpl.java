package com.culturestamp.back.service.impl;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.culturestamp.back.controller.request.CategoryRequest;
import com.culturestamp.back.entity.Category;
import com.culturestamp.back.repository.CategoryRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl {
	@Autowired
	private CategoryRepository categoryRepository;


	public Category addCategory(CategoryRequest categoryRequest){
		// final User user = userService.read(categoryRequest.getUserId());
		final Category category = new Category(categoryRequest.getCategoryName(), categoryRequest.getReviewCount());
		return categoryRepository.save(category);
	}

	public Category findCategory(Long categoryId) throws Exception {
		return categoryRepository.findById(categoryId).orElseThrow(NullPointerException::new);
	}

	public void removeCategory(Long categoryId){
		categoryRepository.deleteById(categoryId);
	}
	public Category modifyCategory(Long categoryId,CategoryRequest categoryRequest) throws Exception {
		Optional<Category> optionalCategory = categoryRepository.findById(categoryId);
		if (optionalCategory.isEmpty()) {
			throw new EntityNotFoundException(
				"Category not present in the database"
			);
		}
		Category modifyCategory = optionalCategory.get();
		if(categoryRequest.getCategoryName()!=null)modifyCategory.setCategoryName(categoryRequest.getCategoryName());
		if(categoryRequest.getReviewCount()!=null)modifyCategory.setReviewCount(categoryRequest.getReviewCount());
		return categoryRepository.save(modifyCategory);
	}


}
