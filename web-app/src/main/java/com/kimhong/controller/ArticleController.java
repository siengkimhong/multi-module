package com.kimhong.controller;

import com.kimhong.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/articles")
public class ArticleController {
    @Value("${api.image-uri}")
    String imageUri;

    private ArticleService articleService;

    @Autowired
    public void setArticleService(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping
    public String showArticle(ModelMap map){
        map.addAttribute("articles", articleService.getAllArticle().getData());
        map.addAttribute("imageUri", imageUri);
        return "pages/article";
    }
}
