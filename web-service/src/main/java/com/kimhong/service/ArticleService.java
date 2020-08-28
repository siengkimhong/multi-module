package com.kimhong.service;

import com.kimhong.repository.dto.ArticleDto;

import java.util.List;

public interface ArticleService {
    ArticleDto save(ArticleDto newArticle);

    List<ArticleDto> findAl();

    List<ArticleDto> recentPost();

    List<ArticleDto> mostPopular();
}
