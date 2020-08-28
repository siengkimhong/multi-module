package com.kimhong.rest.controller;

import com.kimhong.constant.ApiConstant;
import com.kimhong.repository.dto.ArticleDto;
import com.kimhong.rest.message.SuccessMessage;
import com.kimhong.rest.request.ArticleRequest;
import com.kimhong.rest.response.ApiResponse;
import com.kimhong.rest.response.ArticleResponse;
import com.kimhong.service.implementation.ArticleServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(ApiConstant.API_VERSION)
public class ArticleRestController {
    private final ArticleServiceImpl service;
    private ModelMapper mapper;

    @Autowired
    public ArticleRestController(ArticleServiceImpl service) {
        this.service = service;
    }

    @Autowired
    public void setMapper(ModelMapper mapper) {
        this.mapper = mapper;
    }

    @GetMapping(ApiConstant.ARTICLES_URL)
    public ResponseEntity<ApiResponse<List<ArticleResponse>>> getArticles(){
        ApiResponse<List<ArticleResponse>> response = new ApiResponse<>();
        List<ArticleDto> articleDtoList = service.findAl();
        return getApiResponseResponseEntity(response, articleDtoList, mapper);
    }

    @PostMapping(ApiConstant.ARTICLES_URL)
    public ResponseEntity<ApiResponse<ArticleResponse>> saveArticle(
            @RequestBody ArticleRequest articleRequest
    ){

        ApiResponse<ArticleResponse> response = new ApiResponse<>();
        ArticleDto articleDto = mapper.map(articleRequest, ArticleDto.class);
        ArticleDto saveArticle = service.save(articleDto);
        ArticleResponse articleResponse = mapper.map(saveArticle, ArticleResponse.class);
        response.setResponse(SuccessMessage.IS_SAVE.value(),
                true,
                HttpStatus.CREATED.value(),
                articleResponse);
        return ResponseEntity.ok(response);
    }

    @GetMapping(ApiConstant.ARTICLES_URL_RECENT)
    public ResponseEntity<ApiResponse<List<ArticleResponse>>> getRecentPost(){
        ApiResponse<List<ArticleResponse>> response = new ApiResponse<>();
        List<ArticleDto> articleDtoList = service.recentPost();
        return getApiResponseResponseEntity(response, articleDtoList, mapper);
    }

    private static ResponseEntity<ApiResponse<List<ArticleResponse>>> getApiResponseResponseEntity(
            ApiResponse<List<ArticleResponse>> response,
            List<ArticleDto> articleDtoList, ModelMapper mapper
    ) {
        List<ArticleResponse> articleResponseList = new ArrayList<>();
        for (ArticleDto a : articleDtoList){
            articleResponseList.add(mapper.map(a, ArticleResponse.class));
        }
        response.setResponse(SuccessMessage.FOUND_ALL.value(), true,
                HttpStatus.OK.value(),
                articleResponseList);
        return ResponseEntity.ok(response);
    }

    @GetMapping(ApiConstant.ARTICCES_URL_POP)
    public ResponseEntity<ApiResponse<List<ArticleResponse>>> getMostPopularArticle(){

        ApiResponse<List<ArticleResponse>> response = new ApiResponse<>();
        List<ArticleDto> articleDtoList = service.mostPopular();
        return getApiResponseResponseEntity(response, articleDtoList, mapper);
    }
}
