package com.example.demo1.repository;

import com.example.demo1.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentsRepo extends JpaRepository<Comment, Long> {
}
