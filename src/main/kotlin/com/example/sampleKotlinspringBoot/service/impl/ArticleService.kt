package com.example.sampleKotlinspringBoot.service.impl

import com.example.sampleKotlinspringBoot.bo.Article
import com.example.sampleKotlinspringBoot.repository.ArticleRepository
import com.example.sampleKotlinspringBoot.service.IArticleService
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Repository
import org.springframework.web.server.ResponseStatusException

@Repository
class ArticleService(
    private val repository: ArticleRepository
) : IArticleService {

    override fun save(t: Article): Article =
            repository.save(t)

    override fun update(id: Long, t: Article): Article {
        if (repository.existsById(id)) {
            return repository.save(t)
        } else {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, "This id article does not exist")
        }
    }

    override fun delete(id: Long): String {
        return if (repository.existsById(id)) {
            repository.deleteById(id)
            "Delete success"
        } else {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, "This id article does not exist")
        }
    }

    override fun findAll(): List<Article> =
            repository.findAll().toList()

    override fun findBySlug(slug: String): Article? =
            repository.findBySlug(slug) ?: throw ResponseStatusException(HttpStatus.NOT_FOUND, "This article does not exist")

    override fun findAllByOrderByAddedAtDesc(): Iterable<Article> =
            repository.findAllByOrderByAddedAtDesc()
}