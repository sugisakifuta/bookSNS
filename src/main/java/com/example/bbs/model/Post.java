package com.example.bbs.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity
@Data
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String content;
    private String authors_name; // 投稿者の名前を保存するフィールド
    private String publishing_company; // 出版社を保存するフィールド
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate publishing_year; // 出版年を保存するフィールド

    private LocalDateTime createdAt = LocalDateTime.now();
    private LocalDateTime updatedAt = LocalDateTime.now();

    @PrePersist
    public void onCreate() {
        createdAt = LocalDateTime.now();
    }

    @PreUpdate
    public void onUpdate() {
        updatedAt = LocalDateTime.now();
    }
}
