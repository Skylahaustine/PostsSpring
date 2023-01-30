package com.example.demo1.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Entity
@Table(name = "user")

public class User {
    @Id
    @GeneratedValue
    private Long id;
//    @Column(name = "user_nam", nullable = false)
    private String userName;
    private String otherName;
}
