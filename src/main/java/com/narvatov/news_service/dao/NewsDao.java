package com.narvatov.news_service.dao;

import com.narvatov.news_service.model.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NewsDao extends JpaRepository<News, Integer> {

    @Query(value = "SELECT * FROM News ORDER BY creation_date DESC", nativeQuery = true)
    List<News> findAllSortedByDate();

    @Query(value = "SELECT * FROM News WHERE category = :category ORDER BY creation_date DESC", nativeQuery = true)
    List<News> findByCategorySortedByDate(String category);

}
