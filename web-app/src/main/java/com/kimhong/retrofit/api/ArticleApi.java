package com.kimhong.retrofit.api;


import com.kimhong.retrofit.model.ApiResponse;
import com.kimhong.retrofit.model.Article;
import retrofit2.Call;
import retrofit2.http.GET;

import java.util.List;

public interface ArticleApi {
    @GET("articles/recent")
    Call<ApiResponse<List<Article>>> getRecentArticles();

    @GET("articles/popular")
    Call<ApiResponse<List<Article>>> getPopularArticle();

    @GET("articles")
    Call<ApiResponse<List<Article>>> getAllArticle();
}
