package com.narvatov.news_service.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class CommentDTO {

    private int id;
    private String text;
    @JsonProperty("creation_date")
    private LocalDateTime creationDate;
    private SimpleUserDTO author;

}
