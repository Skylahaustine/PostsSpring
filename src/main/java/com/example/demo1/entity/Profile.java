package com.example.demo1.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "profile")
public class Profile {
    @Id
    @GeneratedValue
    private Long id;
    private String profileName;
@OneToOne
@JoinColumn(name = "user_id")
    private User user;

}
