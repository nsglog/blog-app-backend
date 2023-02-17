package com.scaler.blogappspringboot.articles;

import com.scaler.blogappspringboot.users.UserEntity;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import java.time.LocalDateTime;

@Entity(name = "articles")
@Getter
@Setter
@RequiredArgsConstructor
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ArticleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column (nullable = false)
    @NonNull
    private Long id;
    @NonNull
    private String title;
    @NonNull
    @Column (unique = true)
    private String slug;
    @Nullable
    private String subtitle;
    @Nullable
    private String body;
    @CreatedDate
    private LocalDateTime createdAt;
    @ManyToOne
    @JoinColumn(name = "authorId", nullable = false)
    private UserEntity author;


    //TODO : add tags
}
