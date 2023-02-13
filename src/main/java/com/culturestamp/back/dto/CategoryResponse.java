package com.culturestamp.back.dto;

import com.culturestamp.back.entity.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategoryResponse {
	private Long id;
	private String categoryName;
	private Long reviewCount;

	public CategoryResponse(Category category){
		this.id = category.getId();
		this.categoryName = category.getCategoryName();
		this.reviewCount = category.getReviewCount();
	}

	public static CategoryResponse fromEntity(Category category) {
		return CategoryResponse.builder()
			.id(category.getId())
			.categoryName(category.getCategoryName())
			.reviewCount(category.getReviewCount())
			.build();
	}
}
