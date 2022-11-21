package com.culturestamp.back.controller.request;

import com.culturestamp.back.entity.Review;
import com.culturestamp.back.entity.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TagRequest {
	private String tagName;
	private Review review;
	public TagRequest(String tagName) {
		this.tagName = tagName;
	}

	public String getTagName() {
		return tagName;
	}
}
