package com.example.my_blog.dto.request;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class PatchRequest {
    private String title;
    private String content;
}
