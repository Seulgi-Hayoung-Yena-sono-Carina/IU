package com.example.my_blog.controller;

import com.example.my_blog.domain.Article;
import com.example.my_blog.dto.response.ArticleViewResponse;
import com.example.my_blog.dto.response.ViewResponse;
import com.example.my_blog.service.BlogService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class BlogViewController {
    private final BlogService blogService;
    
    @GetMapping("/articles")
    public String getArticles(Model model){
        List<ArticleViewResponse> articles=blogService.findAll().stream()
                .map(ArticleViewResponse::new)
                .toList();
        model.addAttribute("articles",articles);
        
        return "articleList";
    }
    @GetMapping("/articles/{id}")
    public String getArticle(@PathVariable("id")Long id,Model model){
        Article article=blogService.findById(id);
        model.addAttribute("article",new ViewResponse(article));

        return "article";
    }

    @GetMapping("/new-article")
    public String newArticle(@RequestParam(value="id",required = false)Long id,Model model){
        if(id==null) {
            model.addAttribute("article", new ViewResponse());
        }else{
            Article article=blogService.findById(id);
            model.addAttribute("article",new ViewResponse(article));
        }
        return "newArticle";
    }

}
