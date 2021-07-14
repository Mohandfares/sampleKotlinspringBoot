package com.example.sampleKotlinspringBoot

import org.springframework.boot.Banner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication

@SpringBootApplication
@EnableConfigurationProperties(BlogProperties::class)
class SampleKotlinspringBootApplication

fun main(args: Array<String>) {
	runApplication<SampleKotlinspringBootApplication>(*args)
}
