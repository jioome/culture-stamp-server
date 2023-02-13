package com.culturestamp.back.repository;

import com.culturestamp.back.dto.ReviewResponse;
import com.culturestamp.back.entity.Image;
import com.culturestamp.back.entity.Review;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, Long> {
}
