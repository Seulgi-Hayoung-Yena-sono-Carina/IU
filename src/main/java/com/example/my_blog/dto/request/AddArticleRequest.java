package com.example.my_blog.dto.request;

import com.example.my_blog.domain.Article;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor//@NoArgsConstructor은 request에서 필수적으로 요구된다
@Setter//보통 request에선 @Data를 쓰나 여기선 @Getter가 필요 없다
public class AddArticleRequest {
    private String title;
    private String content;

    public Article toEntity(){
        return Article.builder()
                .title(title)
                .content(content)
                .build();
    }
}
