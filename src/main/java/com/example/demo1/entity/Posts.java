package com.example.demo1.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "posts")
public class Posts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String postName;
    private String postSecret;

@ManyToOne
@JoinColumn(name = "user_id")

    private User user;


}
