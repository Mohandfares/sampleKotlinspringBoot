package com.example.sampleKotlinspringBoot.repository

import com.example.sampleKotlinspringBoot.bo.Article
import com.example.sampleKotlinspringBoot.bo.Author
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param


interface ArticleRepository : CrudRepository<Article, Long> {
    fun findBySlug(slug: String): Article?
    fun findAllByOrderByAddedAtDesc(): Iterable<Article>
    fun findByAuthor(author: Author): Iterable<Article>
}

interface AuthorRepository : CrudRepository<Author, Long> {
    fun findByLogin(login: String): Author?
}

interface AuthorJpaRepository : JpaRepository<Author, Long> {
    @Query("FROM Author WHERE login = :login")
    fun findAllByLogin(@Param("login") login: String): List<Author>
}