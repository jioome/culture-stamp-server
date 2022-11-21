package com.culturestamp.back.repository;

import static javax.print.attribute.TextSyntax.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Optional;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.culturestamp.back.entity.Category;
import com.culturestamp.back.entity.Role;
import com.culturestamp.back.entity.User;

@SpringBootTest
public class CategoryRepositoryTest {

	@Autowired
	private CategoryRepository repository;



	private User user;
	private Category category,category1;

	// 테스트 메서드 실행 이전에 수행된다.
	@BeforeEach
	@DisplayName("user, category 데이터 설정")
	void setup() throws ParseException {
		user = User.builder()
			.userId(2L)
			.nickname("가가")
			.loginId("testID")
			.email("이메일@naver.com")
			.password("passwww")
			.role(Role.USER)
			.lastLoginAt(new SimpleDateFormat("yyyyMMdd").parse("20221028"))
			.failCount(0)
			.build();

		category = new Category("Movie",3L,user);
		category1 = new Category(1L,"Movie2",2L,user);

	}

	@Test
	@DisplayName("카테고리 등록")
	void test_카테고리등록(){
		Category actual = repository.save(category);
		assertEquals(category.getCategoryId(), actual.getCategoryId());

	}

	@Test
	@DisplayName("카테고리 조회")
	void 카테고리조회(){
		Category actual = repository.findById(category1.getCategoryId()).get();
		assertEquals(category1.getCategoryId(),actual.getCategoryId());
	}

	@Test
	@DisplayName("카테고리 삭제")
	void 카테고리삭제(){
		// select 먼저
		repository.deleteById(category1.getCategoryId());






	}

}
