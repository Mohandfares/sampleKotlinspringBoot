package com.example.sampleKotlinspringBoot.service.impl

import com.example.sampleKotlinspringBoot.bo.User
import com.example.sampleKotlinspringBoot.repository.UserRepository
import com.example.sampleKotlinspringBoot.service.IUserService
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Repository
import org.springframework.web.server.ResponseStatusException

@Repository
class UserService(
    private val repository: UserRepository
) : IUserService {

    override fun save(t: User): User =
            repository.save(t)

    override fun update(id: Long, t: User): User {
        if (repository.existsById(id)) {
            return repository.save(t)
        } else {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, "This id user does not exist")
        }
    }

    override fun delete(id: Long): String {
        return if (repository.existsById(id)) {
            repository.deleteById(id)
            "Delete success"
        } else {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, "This id user does not exist")
        }
    }

    override fun findAll(): List<User> =
            repository.findAll().toList()

    override fun findByLogin(login: String): User? =
            repository.findByLogin(login) ?: throw ResponseStatusException(HttpStatus.NOT_FOUND, "This user does not exist")
}