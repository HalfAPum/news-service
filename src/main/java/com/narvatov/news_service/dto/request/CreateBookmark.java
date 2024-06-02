package com.narvatov.news_service.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CreateBookmark {

    @JsonProperty("news_id")
    private int newsId;

}
