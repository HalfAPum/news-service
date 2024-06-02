package com.narvatov.news_service.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.narvatov.news_service.model.News;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class DetailedNewsDTO {

    private int id;
    private String headline;
    private String content;
    private SimpleUserDTO author;
    @JsonProperty("creation_date")
    private LocalDateTime creationDate;
    private String category;
    private List<CommentDTO> comments;

    public DetailedNewsDTO(News news, SimpleUserDTO author, List<CommentDTO> comments) {
        id = news.getId();
        headline = news.getHeadline();
        content = news.getContent();
        this.author = author;
        creationDate = news.getCreationDate();
        category = news.getCategory();
        this.comments = comments;
    }

}
