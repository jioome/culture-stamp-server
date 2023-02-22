package com.culturestamp.back.controller.request;

import com.culturestamp.back.entity.Review;
import com.culturestamp.back.entity.Tag;
import com.culturestamp.back.entity.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class TagRequest {
	private String tagName;
	private Long reviewId;

	public Tag toEntity(TagRequest tagRequest){
		return Tag.builder()
			.tagName(tagRequest.tagName)
			.build();
	}

}
