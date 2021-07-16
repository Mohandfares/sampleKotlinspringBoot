package com.example.sampleKotlinspringBoot.datacontroller

import com.example.sampleKotlinspringBoot.BlogProperties
import com.example.sampleKotlinspringBoot.Ext.format
import com.example.sampleKotlinspringBoot.bo.Article
import com.example.sampleKotlinspringBoot.bo.Author
import com.example.sampleKotlinspringBoot.repository.ArticleRepository
import com.example.sampleKotlinspringBoot.repository.UserRepository
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.server.ResponseStatusException

@Controller
class HtmlController(
    private val repository: ArticleRepository,
    private val properties: BlogProperties
) {

    @GetMapping("/")
    fun blog(model: Model): String {
        model["title"] = properties.title
        model["banner"] = properties.banner
        model["articles"] = repository.findAllByOrderByAddedAtDesc().map { it.render() }
        return "blog"
    }

    fun Article.render() = RenderedArticle(
        slug,
        title,
        headline,
        content,
        author,
        addedAt.format()
    )

    data class RenderedArticle(
            val slug: String,
            val title: String,
            val headline: String,
            val content: String,
            val author: Author,
            val addedAt: String)

}
