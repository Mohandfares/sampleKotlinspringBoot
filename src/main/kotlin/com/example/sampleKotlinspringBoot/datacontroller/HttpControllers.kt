package com.example.sampleKotlinspringBoot.datacontroller

import com.example.sampleKotlinspringBoot.bo.Article
import com.example.sampleKotlinspringBoot.bo.Author
import com.example.sampleKotlinspringBoot.service.IArticleService
import com.example.sampleKotlinspringBoot.service.IAuthorService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException

@RestController
@RequestMapping("/api/article")
class ArticleController {

    @Autowired
    lateinit var repository: IArticleService

    @GetMapping("/")
    fun findAll() = repository.findAllByOrderByAddedAtDesc()

    @GetMapping("/{slug}")
    fun findOne(@PathVariable slug: String) =
        repository.findBySlug(slug)

    @PostMapping("/save")
    fun save(@RequestBody article: Article): Article =
            repository.save(article)

    @PutMapping("/update/{id}")
    fun update(
        @PathVariable id: Long,
        @RequestBody article: Article
    ): Article = repository.update(id,article)


    @DeleteMapping("/delete/{id}")
    fun delete(@PathVariable id: Long): String =
            repository.delete(id)
}

@RestController
@RequestMapping("/api/user")
class UserController {

    @Autowired
    lateinit var repository: IAuthorService

    @GetMapping("/")
    fun findAll() = repository.findAll()

    @GetMapping("/{login}")
    fun findOne(@PathVariable login: String) =
        repository.findByLogin(login)

    @PostMapping("/save")
    fun save(@RequestBody user: Author): Author =
        repository.save(user)

    @PutMapping("/update/{id}")
    fun update(
        @PathVariable id: Long,
        @RequestBody user: Author
    ): Author = repository.update(id,user)

    @DeleteMapping("/delete/{id}")
    fun delete(@PathVariable id: Long): String =
            repository.delete(id)
}