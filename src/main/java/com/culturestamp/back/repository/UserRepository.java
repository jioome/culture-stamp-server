package com.culturestamp.back.repository;

import com.culturestamp.back.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Category,Long> {
}
