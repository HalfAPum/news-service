package com.narvatov.news_service.service;

import com.narvatov.news_service.dao.NewsDao;
import com.narvatov.news_service.dto.request.CreateNews;
import com.narvatov.news_service.dto.response.CommentDTO;
import com.narvatov.news_service.dto.response.DetailedNewsDTO;
import com.narvatov.news_service.dto.response.SimpleNewsDTO;
import com.narvatov.news_service.dto.response.SimpleUserDTO;
import com.narvatov.news_service.mapper.MapperKt;
import com.narvatov.news_service.model.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NewsService {

    @Autowired
    private NewsDao dao;

    public List<SimpleNewsDTO> getAll() {
        List<News> news = dao.findAllSortedByDate();

        //TODO FUCK FETCH USER
        List<SimpleUserDTO> authors = new ArrayList<>();

        return MapperKt.mapToSimpleNewsDTO(news, authors);
    }

    public List<SimpleNewsDTO> getByCategory(String category) {
        List<News> news = dao.findByCategorySortedByDate(category);

        //TODO FUCK FETCH USER
        List<SimpleUserDTO> authors = new ArrayList<>();

        return MapperKt.mapToSimpleNewsDTO(news, authors);
    }

    public DetailedNewsDTO getDetailedNewsById(int id) {
        News news = dao.findById(id).orElseThrow(() -> new IllegalArgumentException("Id is not present in news table"));

        //TODO FUCK FETCH USER
        SimpleUserDTO author = new SimpleUserDTO();

        //TODO FUCK FETCH COMMENTS
        List<CommentDTO> comments = new ArrayList<>();

        return new DetailedNewsDTO(news, author, comments);
    }

    public SimpleNewsDTO getSimpleNewsById(int id) {
        News news = dao.findById(id).orElseThrow(() -> new IllegalArgumentException("Id is not present in news table"));

        //TODO FUCK FETCH USER
        SimpleUserDTO author = new SimpleUserDTO();

        return new SimpleNewsDTO(news, author);
    }


    public News add(int userId, CreateNews createNews) {
        return dao.save(createNews.getNews(userId));
    }


    public News update(News news) {
        return dao.save(news);
    }


    public int delete(int id) {
        dao.deleteById(id);

        return id;
    }

}
