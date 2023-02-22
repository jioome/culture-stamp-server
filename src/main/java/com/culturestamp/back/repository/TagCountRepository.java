package com.culturestamp.back.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;

import com.culturestamp.back.dto.ReviewResponse;
import com.culturestamp.back.dto.UserServiceResponse;
import com.culturestamp.back.entity.TagCount;

public interface TagCountRepository extends JpaRepository<TagCount,Long> {
	Optional<TagCount> findByTagName(String tagName);
	List<TagCount> findTop10ByOrderByTagCountDesc();
}
