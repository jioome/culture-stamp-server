package com.culturestamp.back.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Tag {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "tag_id")
	private Long id;

	@Column(name = "tag_name")
	private String tagName;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="review_id")
	private Review review;



	public Tag() {

	}


}
