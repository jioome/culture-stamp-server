package com.culturestamp.back.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.ColumnDefault;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class TagCount {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "count_id")
	private Long id;

	@Column(name = "tag_name")
	private String tagName;

	@Column(name = "tag_count")
	private Integer tagCount = 1;

	@Builder
	public TagCount(Long id, String tagName, Integer tagCount) {
		this.id = id;
		this.tagName = tagName;
		this.tagCount = tagCount;
	}
}
