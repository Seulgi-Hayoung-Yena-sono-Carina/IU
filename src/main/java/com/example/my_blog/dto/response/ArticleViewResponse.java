package com.example.my_blog.dto.response;

import com.example.my_blog.domain.Article;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ArticleViewResponse {
    private final Long id;
    private final String title;
    private final String content;

    public ArticleViewResponse(Article article){
        this.id=article.getId();
        this.title=article.getTitle();
        this.content= article.getContent();
    }
}
