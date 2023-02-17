package com.scaler.blogappspringboot.comments;

import com.scaler.blogappspringboot.articles.ArticleEntity;
import com.scaler.blogappspringboot.users.UserEntity;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import java.time.LocalDateTime;

@Entity(name = "comments")
@Getter
@Setter
@RequiredArgsConstructor
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CommentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column (nullable = false)
    private Long id;
    @Nullable
    private String title;
    @NonNull
    private String body;
    @CreatedDate
    private LocalDateTime createdAt;
    @ManyToOne
    @JoinColumn (name = "article_id", nullable = false)
    private ArticleEntity article;
    @ManyToOne
    @JoinColumn (name = "author_id", nullable = false)
    private UserEntity author;
}
