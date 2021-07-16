package com.example.sampleKotlinspringBoot.service

import com.example.sampleKotlinspringBoot.bo.Author
import org.springframework.stereotype.Service

@Service
interface IUserService : AbstractService<Author,Long> {
    fun findByLogin(login: String): Author?
}