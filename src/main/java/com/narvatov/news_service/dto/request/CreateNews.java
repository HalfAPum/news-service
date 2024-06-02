package com.narvatov.news_service.dto.request;

import com.narvatov.news_service.model.News;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CreateNews {

    private String headline;
    private String content;
    private String category;

    public News getNews(int author) {
        return new News(headline, content, author, category);
    }

}
