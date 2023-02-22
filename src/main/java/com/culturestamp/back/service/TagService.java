package com.culturestamp.back.service;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.web.PageableDefault;

import com.culturestamp.back.controller.request.TagRequest;
import com.culturestamp.back.controller.request.TodoRequest;
import com.culturestamp.back.dto.ReviewResponse;
import com.culturestamp.back.dto.TagResponse;
import com.culturestamp.back.dto.TodoResponse;
import com.culturestamp.back.entity.Tag;
import com.culturestamp.back.entity.TagCount;
import com.culturestamp.back.entity.Todo;

public interface TagService {
	TagResponse addTag(TagRequest tagRequest);
	Slice<TagResponse> findAllTag(Pageable pageable);
	Tag findTag(Long tagId);
	void removeTag(Long tagId);
	List<Tag> search(String keyword);
	List<TagCount> topTag();
}
