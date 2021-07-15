package com.example.sampleKotlinspringBoot.datacontroller

import com.example.sampleKotlinspringBoot.bo.Article
import com.example.sampleKotlinspringBoot.bo.User
import com.example.sampleKotlinspringBoot.repository.ArticleRepository
import com.example.sampleKotlinspringBoot.repository.UserRepository
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException

@RestController
@RequestMapping("/api/article")
class ArticleController(private val repository: ArticleRepository) {

    @GetMapping("/")
    fun findAll() = repository.findAllByOrderByAddedAtDesc()

    @GetMapping("/{slug}")
    fun findOne(@PathVariable slug: String) =
        repository.findBySlug(slug) ?: throw ResponseStatusException(HttpStatus.NOT_FOUND, "This article does not exist")

    @PostMapping("/save")
    fun save(@RequestBody article: Article): Article =
            repository.save(article)

    @PutMapping("/update/{id}")
    fun update(
        @PathVariable id: Long,
        @RequestBody article: Article
    ): Article {
        if (repository.existsById(id)) {
            return repository.save(article)
        } else {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, "This id article does not exist")
        }
    }

    @DeleteMapping("/delete/{id}")
    fun delete(@PathVariable id: Long): String {
        return if (repository.existsById(id)) {
            repository.deleteById(id)
            "Delete success"
        } else {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, "This id article does not exist")
        }
    }
}

@RestController
@RequestMapping("/api/user")
class UserController(private val repository: UserRepository) {

    @GetMapping("/")
    fun findAll() = repository.findAll()

    @GetMapping("/{login}")
    fun findOne(@PathVariable login: String) =
        repository.findByLogin(login) ?: throw ResponseStatusException(HttpStatus.NOT_FOUND, "This user does not exist")

    @PostMapping("/save")
    fun save(@RequestBody user: User): User =
        repository.save(user)

    @PutMapping("/update/{id}")
    fun update(
        @PathVariable id: Long,
        @RequestBody user: User
    ): User {
        if (repository.existsById(id)) {
            return repository.save(user)
        } else {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, "This id user does not exist")
        }
    }

    @DeleteMapping("/delete/{id}")
    fun delete(@PathVariable id: Long): String {
        return if (repository.existsById(id)) {
            repository.deleteById(id)
            "Delete success"
        } else {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, "This id user does not exist")
        }
    }
}