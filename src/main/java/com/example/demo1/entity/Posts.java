package com.example.demo1.entity;

import com.example.demo1.model.PostData;
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

public PostData entityToDto(){
    PostData pd = new PostData();
    pd.setId(getId());
    pd.setPostName(getPostName());
    return  pd;
}


}
