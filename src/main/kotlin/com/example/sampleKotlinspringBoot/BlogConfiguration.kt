package com.example.sampleKotlinspringBoot


import org.springframework.context.annotation.Configuration

@Configuration
class BlogConfiguration {

    /*@Bean
    fun databaseInitializer(
        userRepository: UserRepository,
        articleRepository: ArticleRepository
    ) = ApplicationRunner {
        val smaldini = userRepository.save(Author("smaldini", "Stéphane", "Maldini"))
        articleRepository.save(Article(
            title = "Reactor Bismuth is out",
            headline = "Lorem ipsum",
            content = "dolor sit amet",
            author = smaldini
        ))
        articleRepository.save(Article(
            title = "Reactor Aluminium has landed",
            headline = "Lorem ipsum",
            content = "dolor sit amet",
            author = smaldini
        ))
    }*/
}