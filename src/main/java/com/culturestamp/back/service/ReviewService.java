package com.culturestamp.back.service;

import com.culturestamp.back.controller.request.ReviewRequest;
import com.culturestamp.back.dto.ReviewResponse;

public interface ReviewService {
    ReviewResponse addReview(ReviewRequest reviewRequest);
}
