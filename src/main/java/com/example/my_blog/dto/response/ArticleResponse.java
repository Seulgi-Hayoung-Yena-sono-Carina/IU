package com.example.my_blog.dto.response;

import com.example.my_blog.domain.Article;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data//보통 response에선 @Getter을 쓰나 여기선 @Setter가 사용된다
@AllArgsConstructor//@response에선 @AllArgsConstructor가 요구된다
public class ArticleResponse {
    private final String title;
    private final String content;

    public ArticleResponse(Article article){
        this.title=article.getTitle();
        this.content=article.getContent();
    }
}
