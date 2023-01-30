package com.example.demo1.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "posts")
public class Posts {
    @Id
    private Long id;
    private String postName;

//@ManyToOne(fetch = FetchType.LAZY)
//    private User user;


}
