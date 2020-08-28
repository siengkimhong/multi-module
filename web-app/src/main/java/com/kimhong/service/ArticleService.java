package com.kimhong.service;

import com.kimhong.retrofit.api.ApiGenerator;
import com.kimhong.retrofit.api.ArticleApi;
import com.kimhong.retrofit.model.ApiResponse;
import com.kimhong.retrofit.model.Article;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class ArticleService {
    @Value("${auth-user}")
    private String auth_user;
    @Value("${auth-password")
    private String auth_password;

    public ApiResponse<List<Article>> getRecentArticles(){
        ArticleApi articleApi = ApiGenerator.createService(ArticleApi.class, "kimhong", "kimhong");
        ApiResponse<List<Article>> articleRecentResponse = new ApiResponse<>();
        try {
            articleRecentResponse = articleApi.getRecentArticles().execute().body();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return articleRecentResponse;
    }

    public ApiResponse<List<Article>> getPopularArticle(){
        ArticleApi articleApi = ApiGenerator.createService(ArticleApi.class, "kimhong", "kimhong");
        ApiResponse<List<Article>> articlePopularResponse = new ApiResponse<>();
        try {

            articlePopularResponse = articleApi.getPopularArticle().execute().body();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return articlePopularResponse;
    }

    public ApiResponse<List<Article>> getAllArticle(){
        ArticleApi articleApi = ApiGenerator.createService(
                ArticleApi.class,
                "kimhong",
                "kimhong");
        ApiResponse<List<Article>> allArticleResponse = new ApiResponse<>();
        try {
            allArticleResponse = articleApi.getAllArticle().execute().body();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return allArticleResponse;
    }
}
