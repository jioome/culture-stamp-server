package com.culturestamp.back.dto;

import com.culturestamp.back.entity.Review;
import com.culturestamp.back.entity.Tag;
import com.culturestamp.back.entity.TagCount;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class TagResponse {
	private Long id;
	private String tagName;
	private Review review;

	public TagResponse(Tag tag) {
		this.id = tag.getId();
		this.tagName = tag.getTagName();
		this.review = tag.getReview();
	}

	@Builder
	public TagResponse(Long id, String tagName, Review review) {
		this.id = id;
		this.tagName = tagName;
		this.review = review;
	}
}
