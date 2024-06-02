package com.narvatov.news_service.controller;

import com.narvatov.news_service.dto.request.CreateNews;
import com.narvatov.news_service.dto.response.DetailedNewsDTO;
import com.narvatov.news_service.dto.response.SimpleNewsDTO;
import com.narvatov.news_service.model.News;
import com.narvatov.news_service.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/news")
public class NewsController {

    @Autowired
    private NewsService service;


    //Provide paging
    @GetMapping("getAll")
    public List<SimpleNewsDTO> getAll() {
        return service.getAll();
    }

    @GetMapping("getByCategory/{category}")
    public List<SimpleNewsDTO> getByCategory(@PathVariable String category) {
        return service.getByCategory(category);
    }

    @GetMapping("get/{id}")
    public DetailedNewsDTO get(@PathVariable int id) {
        return service.getDetailedNewsById(id);
    }


    @PostMapping("add")
    public News add(@RequestBody CreateNews createNews) {
        return service.add(1, createNews);
    }

    @DeleteMapping("delete/{id}")
    public int delete(@PathVariable int id) {
        return service.delete(id);
    }

}
