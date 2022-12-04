package com.culturestamp.back.controller;

import com.culturestamp.back.controller.request.ReviewRequest;
import com.culturestamp.back.dto.ReviewResponse;
import com.culturestamp.back.service.ReviewService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/review")
public class ReviewController {
    private final ReviewService service;

    @PostMapping()
    public ResponseEntity<ReviewResponse> reviewAdd(@RequestBody ReviewRequest reviewRequest){
        return ResponseEntity.ok( service.addReview(reviewRequest) );
    }

}
