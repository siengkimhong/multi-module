package com.kimhong.controller;

import com.kimhong.retrofit.model.ApiResponse;
import com.kimhong.retrofit.model.Category;
import com.kimhong.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.concurrent.ExecutionException;

@Controller
@RequestMapping("/categories")
public class CategoryController {
    private CategoryService service;

    @Autowired
    public CategoryController(CategoryService service) {

        this.service = service;
    }

    @GetMapping
    public String index(ModelMap map){
        map.addAttribute("categories", service.getCategories().getData());
        return "pages/category";
    }

    @GetMapping("/{id}")
    public String getCategoryByIdView(ModelMap map, @PathVariable("id") int id){
        ApiResponse<Category> category = new ApiResponse<>();
        try {
            category = service.getCategoryById(id).get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        map.addAttribute("category", category.getData());
        return "pages/category";
    }
}
