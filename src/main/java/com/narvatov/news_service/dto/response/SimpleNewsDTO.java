package com.narvatov.news_service.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.narvatov.news_service.model.News;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class SimpleNewsDTO {

    private int id;
    private String headline;
    private String content;
    private SimpleUserDTO author;
    @JsonProperty("creation_date")
    private LocalDateTime creationDate;
    private String category;

    public SimpleNewsDTO(News news, SimpleUserDTO author) {
        id = news.getId();
        headline = news.getHeadline();
        content = news.getContent();
        this.author = author;
        creationDate = news.getCreationDate();
        category = news.getCategory();
    }

}
