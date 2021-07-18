package com.example.sampleKotlinspringBoot.service

import com.example.sampleKotlinspringBoot.bo.Article
import com.example.sampleKotlinspringBoot.bo.Author
import org.springframework.stereotype.Service

@Service
interface IArticleService : AbstractService<Article, Long> {
    fun findBySlug(slug: String): Article?
    fun findAllByOrderByAddedAtDesc(): Iterable<Article>
    fun findByAuthor(idAuthor: Long): Iterable<Article>
}