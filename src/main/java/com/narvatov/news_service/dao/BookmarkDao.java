package com.narvatov.news_service.dao;

import com.narvatov.news_service.model.BookmarkedNews;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookmarkDao extends JpaRepository<BookmarkedNews, Integer> {

}
