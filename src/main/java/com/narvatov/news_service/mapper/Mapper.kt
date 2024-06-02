package com.narvatov.news_service.mapper

import com.narvatov.news_service.dto.response.SimpleNewsDTO
import com.narvatov.news_service.dto.response.SimpleUserDTO
import com.narvatov.news_service.model.News

fun List<News>.mapToSimpleNewsDTO(authors: List<SimpleUserDTO>) = mapIndexed { index, news ->
    SimpleNewsDTO(news, authors.getOrNull(index))
}