package com.kimhong.controller.ajax;
import com.kimhong.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("ajax")
public class AjaxCategoryController {
    private CategoryService service;

    @Autowired
    public void setService(CategoryService service) {
        this.service = service;
    }

    @GetMapping("related-categories")
    public String getRelatedCategories(ModelMap map){
        map.addAttribute("categories", service.getCategories().getData());
        return "ajax/category-related";
    }
}
