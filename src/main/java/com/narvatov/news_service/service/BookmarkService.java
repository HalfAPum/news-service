package com.narvatov.news_service.service;

import com.narvatov.news_service.dao.BookmarkDao;
import com.narvatov.news_service.dao.BookmarkedNewsDao;
import com.narvatov.news_service.dto.response.SimpleNewsDTO;
import com.narvatov.news_service.dto.response.SimpleUserDTO;
import com.narvatov.news_service.mapper.MapperKt;
import com.narvatov.news_service.model.BookmarkedNews;
import com.narvatov.news_service.model.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookmarkService {

    @Autowired
    private BookmarkDao dao;
    @Autowired
    private BookmarkedNewsDao bookmarkedNewsDao;

    public BookmarkedNews add(int userId, int newsId) {
        BookmarkedNews bookmarkedNews = new BookmarkedNews(userId, newsId);

        return dao.save(bookmarkedNews);
    }

    public int delete(int userId, int newsId) {
        dao.delete(new BookmarkedNews(userId, newsId));

        return newsId;
    }

    public List<SimpleNewsDTO> getAll(int userId) {
        List<News> bookmarkedNews = bookmarkedNewsDao.findAllBookmarkedNews(userId);

        //TODO FUCK FETCH USER
        List<SimpleUserDTO> authors = new ArrayList<>();

        return MapperKt.mapToSimpleNewsDTO(bookmarkedNews, authors);
    }

}
