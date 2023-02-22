package com.culturestamp.back.controller;

import com.culturestamp.back.controller.request.TagRequest;
import com.culturestamp.back.dto.CommonResponse;
import com.culturestamp.back.dto.ReviewResponse;
import com.culturestamp.back.dto.TagResponse;
import com.culturestamp.back.entity.Tag;
import com.culturestamp.back.entity.TagCount;
import com.culturestamp.back.service.TagService;
import com.culturestamp.back.service.impl.TagServiceImpl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/tag")
public class TagController {
	private final TagService service;

	@PostMapping()
	public ResponseEntity<?> TagAdd(@RequestBody TagRequest tagRequest){
		TagResponse tagResponse = service.addTag(tagRequest);
		return ResponseEntity.ok(new CommonResponse<>("SUCCESS",tagResponse));
	}

	@GetMapping()
	public ResponseEntity<Slice<TagResponse>> tagAll(@PageableDefault(size=20) Pageable pageable){
		return ResponseEntity.ok().body(service.findAllTag(pageable));
	}

	@GetMapping("/{tagId}")
	public ResponseEntity<Tag> tagDetails(@PathVariable Long tagId){
		return ResponseEntity.ok(service.findTag(tagId));
	}

	@DeleteMapping("/{tagId}")
	public ResponseEntity<Void> tagRemove(@PathVariable Long tagId ){
		service.removeTag(tagId);
		return ResponseEntity.ok().build();
	}

	@GetMapping("/search")
	public ResponseEntity<List> search(String keyword){
		System.out.println(service.search(keyword));
		return ResponseEntity.ok(service.search(keyword));
	}

	@GetMapping("/top")
	public ResponseEntity<List<TagCount>> topTagCount(){
		return ResponseEntity.ok(service.topTag());
	}

}
