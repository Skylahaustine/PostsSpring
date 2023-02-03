package com.example.demo1.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

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
    @OneToMany(mappedBy = "user" ,cascade=CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Posts> posts;

    @OneToOne(mappedBy = "user")
    private Profile profile;
}
