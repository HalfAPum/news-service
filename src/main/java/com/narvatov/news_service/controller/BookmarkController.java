package com.narvatov.news_service.controller;

import com.narvatov.news_service.dto.request.CreateBookmark;
import com.narvatov.news_service.dto.response.SimpleNewsDTO;
import com.narvatov.news_service.model.BookmarkedNews;
import com.narvatov.news_service.service.BookmarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/bookmark")
public class BookmarkController {

    @Autowired
    private BookmarkService service;

    @PostMapping("add")
    public BookmarkedNews add(@RequestBody CreateBookmark createBookmark) {
        return service.add(1, createBookmark.getNewsId());
    }

    @DeleteMapping("delete/{id}")
    public int delete(@PathVariable("id") int id) {
        return service.delete(1, id);
    }

    @GetMapping("getAll")
    public List<SimpleNewsDTO> getAll() {
        return service.getAll(1);
    }

}
