package com.example.sampleKotlinspringBoot.service

import com.example.sampleKotlinspringBoot.bo.User
import org.springframework.stereotype.Service

@Service
interface IUserService : AbstractService<User,Long> {
    fun findByLogin(login: String): User?
}