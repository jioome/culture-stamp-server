package com.culturestamp.back.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "category_id")
	private Long id;

	@Column(name = "category_name")
	private String categoryName;

	@Column(name = "review_count")
	private Long reviewCount;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	public Category() {

	}

	@Builder
	public Category(Long id, String categoryName, Long reviewCount, User user) {
		this.id = id;
		this.categoryName = categoryName;
		this.reviewCount = reviewCount;
		this.user = user;
	}

	@Builder
	public Category(String categoryName, Long reviewCount, User user) {
		this.categoryName = categoryName;
		this.reviewCount = reviewCount;
		this.user = user;
	}

	public Category(String categoryName, Long reviewCount) {
	}


}
