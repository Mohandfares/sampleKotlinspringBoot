package com.example.sampleKotlinspringBoot


import com.example.sampleKotlinspringBoot.bo.Article
import com.example.sampleKotlinspringBoot.bo.Author
import com.example.sampleKotlinspringBoot.repository.ArticleRepository
import com.example.sampleKotlinspringBoot.repository.AuthorRepository
import org.springframework.boot.ApplicationRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class BlogConfiguration {

    @Bean
    fun databaseInitializer(
        authorRepository: AuthorRepository,
        articleRepository: ArticleRepository
    ) = ApplicationRunner {
        val fares = authorRepository.save(Author("mohand", "fares", "Maldini"))
        articleRepository.save(Article(
            title = "Reactor Bismuth is out",
            headline = "Lorem ipsum",
            content = "dolor sit amet",
            author = fares
        ))
        articleRepository.save(Article(
            title = "Reactor Aluminium has landed",
            headline = "Lorem ipsum",
            content = "dolor sit amet",
            author = fares
        ))
    }
}