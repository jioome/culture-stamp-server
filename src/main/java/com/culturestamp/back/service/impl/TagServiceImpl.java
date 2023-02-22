package com.culturestamp.back.service.impl;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Service;

import com.culturestamp.back.controller.request.TagRequest;
import com.culturestamp.back.dto.TagResponse;
import com.culturestamp.back.entity.Review;
import com.culturestamp.back.entity.Tag;
import com.culturestamp.back.entity.TagCount;
import com.culturestamp.back.repository.ReviewRepository;
import com.culturestamp.back.repository.TagCountRepository;
import com.culturestamp.back.repository.TagRepository;
import com.culturestamp.back.service.TagService;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class TagServiceImpl implements TagService {
	private final TagRepository tagRepository;
	private final TagCountRepository tagCountRepository;
	private final ReviewRepository reviewRepository;

	@Override
	public TagResponse addTag(TagRequest tagRequest){
		Optional<Review> review = reviewRepository.findById(tagRequest.getReviewId());
		if(review.isEmpty()){
			throw new EntityNotFoundException("Review Not Found");
		}

		Tag tagToCreate = new Tag();
		BeanUtils.copyProperties(tagRequest,tagToCreate);
		tagToCreate.setReview(review.get());

		Tag tag = tagRepository.save(tagToCreate);
		Optional<TagCount> optionalTagCount = tagCountRepository.findByTagName(tagRequest.getTagName());

		if(optionalTagCount.isEmpty()){
			TagCount tagCountCreate = new TagCount();
			tagCountCreate.setTagName(tagRequest.getTagName());
			tagCountRepository.save(tagCountCreate);
		}else{
			TagCount tagCount = optionalTagCount.get();
			tagCount.setTagCount(optionalTagCount.get().getTagCount()+1);
			tagCountRepository.save(tagCount);
		}
		return new TagResponse(tag);
	}

	@Override
	public Slice<TagResponse> findAllTag(@PageableDefault(size = 10, sort = "" ) Pageable pageable) {
		return tagRepository.findAllPagingBy(pageable);
	}

	@Override
	public Tag findTag(Long tagId)  {
		Optional<Tag> tag =  tagRepository.findById(tagId);
		if (tag.isPresent()) {
			return tag.get();
		}
		throw new EntityNotFoundException("Cant find any Tag under given ID");
	}

	@Override
	public void removeTag(Long tagId){
		tagRepository.deleteById(tagId);
	}

	@Transactional
	public List<Tag> search(String keyword){
		List<Tag> tagList = tagRepository.findByTagNameContaining(keyword);
		return tagList;
	}

	public List<TagCount> topTag() {
		// return tagCountRepository.findAll(Sort.by(Sort.Direction.DESC
		// ,"tagCount"));
		return tagCountRepository.findTop10ByOrderByTagCountDesc();
	}

}