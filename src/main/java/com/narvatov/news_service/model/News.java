package com.narvatov.news_service.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
public class News {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String headline;
    @Column(columnDefinition="TEXT")
    private String content;
    private int authorId;
    @JsonProperty("creation_date")
    private LocalDateTime creationDate;
    //define enum of categories
    private String category;
    //add image


    public News(String headline, String content, int authorId, String category) {
        this.headline = headline;
        this.content = content;
        creationDate = LocalDateTime.now();
        this.authorId = authorId;
        this.category = category;
    }

}