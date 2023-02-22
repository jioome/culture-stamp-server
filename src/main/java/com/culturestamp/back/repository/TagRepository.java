package com.culturestamp.back.repository;

import java.util.List;
import java.util.Optional;

import com.culturestamp.back.dto.ReviewResponse;
import com.culturestamp.back.dto.TagResponse;
import com.culturestamp.back.entity.Tag;
import com.culturestamp.back.entity.TagCount;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag,Long> {
	List<Tag> findByTagNameContaining(String tagName);
	Slice<TagResponse> findAllPagingBy(Pageable pageable);
	Iterable<Tag> findAllSortBy(Sort sort);
}
