package com.kimhong.service;

import com.kimhong.retrofit.api.ApiGenerator;
import com.kimhong.retrofit.api.CategoryApi;
import com.kimhong.retrofit.model.ApiResponse;
import com.kimhong.retrofit.model.Category;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class CategoryService {
    @Value("${auth-user}")
    private String auth_user;
    @Value("${auth-password")
    private String auth_password;
    private CategoryApi categoryApi;

    @PostConstruct
    private void init(){
        categoryApi = ApiGenerator.createService(CategoryApi.class, "kimhong", "kimhong");
    }

    public ApiResponse<List<Category>> getCategories(){
        ApiResponse<List<Category>> categories = new ApiResponse<>();
        try {
            categories = categoryApi.getCategories().execute().body();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return categories;
    }

    public CompletableFuture<ApiResponse<Category>> getCategoryById(int id){
        CompletableFuture<ApiResponse<Category>> categoryCompleted =
                new CompletableFuture<>();
        categoryApi.getCategoryById(id).enqueue(new Callback<ApiResponse<Category>>() {
            @Override
            public void onResponse(Call<ApiResponse<Category>> call, Response<ApiResponse<Category>> response) {
                categoryCompleted.complete(response.body());
            }

            @Override
            public void onFailure(Call<ApiResponse<Category>> call, Throwable throwable) {
                throwable.printStackTrace();
            }
        });
        return categoryCompleted;
    }
}
