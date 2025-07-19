package com.example.my_blog.dto.response;

import com.example.my_blog.domain.Article;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class ViewResponse {
    private Long id;
    private String title;
    private String content;
    private LocalDateTime createdAt;

    public ViewResponse(Article article){
        this.id= article.getId();
        this.title= article.getTitle();
        this.content= article.getContent();
        this.createdAt=article.getCreatedAt();
    }
}
