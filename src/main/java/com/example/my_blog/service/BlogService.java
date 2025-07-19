package com.example.my_blog.service;

import com.example.my_blog.domain.Article;
import com.example.my_blog.dto.request.AddArticleRequest;
import com.example.my_blog.dto.request.UpdateArticleRequest;
import com.example.my_blog.repository.BlogRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class BlogService {
    private final BlogRepository blogRepository;

    public Article save(AddArticleRequest request) {
        return blogRepository.save(request.toEntity());
    }

    public List<Article> findAll() {
        return blogRepository.findAll();//findAll도 대상이 없어 null이 나온다 해도 문제 안돼
    }

    public Article findById(Long id) {
        return blogRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found: " + id));//findById는 없으면 알려줘야 해(예외 필수)
    }

    public void delete(Long id) {
        blogRepository.deleteById(id);//delete에는 예외처리 불필요->delete가 안돼도 문제 안돼
    }

    @Transactional/*jpa에선 기본적으로 transactional 제공하기에 post,delete 등에선 transactional 설정 필요 없다
                     그러나 하나 하면 transactional 끝나기에 find 뒤 추가 조치가 있는 모든 경우에 @transactional 붙여야한다*/
    public Article update(Long id, UpdateArticleRequest request) {
        Article article = blogRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found: " + id));

        article.update(Optional.ofNullable(request.getTitle()), Optional.ofNullable(request.getContent()));
        return article;
    }
}
