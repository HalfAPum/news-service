package com.narvatov.news_service.feign;

import com.narvatov.news_service.dto.response.CommentDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "COMMENTS-SERVICE", path = "api/v1/comments")
public interface CommentsInterface {

    @GetMapping("getCommentsByNewId/{id}")
    List<CommentDTO> getCommentsByNewId(@PathVariable("id") int newsId);

}
