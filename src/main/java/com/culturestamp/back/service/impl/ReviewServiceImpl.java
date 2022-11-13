package com.culturestamp.back.service.impl;

import com.culturestamp.back.controller.request.ReviewRequest;
import com.culturestamp.back.dto.ReviewResponse;
import com.culturestamp.back.entity.Review;
import com.culturestamp.back.repository.ReviewRepository;
import com.culturestamp.back.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {
    final private ReviewRepository repository;

    // TODO - 파라미터로 구분하는 거로 해서 findReview랑 합칠지 고민해보기.
    @Override
    public List<ReviewResponse> findReviews(Pageable pageable) {
        return repository.findAllPagingBy(pageable).stream().collect(Collectors.toList());
    }

    @Override
    public ReviewResponse addReview(ReviewRequest reviewRequest) {
        final Review review = repository.save(reviewRequest.toEntity(reviewRequest));
        return new ReviewResponse(review);
    }

    @Override
    public ReviewResponse findReview(Long reviewId) {
        final Review review = repository.findById(reviewId).orElseThrow(IllegalArgumentException::new);
        return new ReviewResponse(review);
    }


}
