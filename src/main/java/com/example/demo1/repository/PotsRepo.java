package com.example.demo1.repository;

import com.example.demo1.entity.Posts;
import org.springframework.data.jpa.repository.JpaRepository;
public interface PotsRepo  extends JpaRepository<Posts, Long> {
}
