package com.example.sampleKotlinspringBoot.service.impl

import com.example.sampleKotlinspringBoot.bo.Author
import com.example.sampleKotlinspringBoot.repository.UserRepository
import com.example.sampleKotlinspringBoot.service.IUserService
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Repository
import org.springframework.web.server.ResponseStatusException

@Repository
class UserService(
    private val repository: UserRepository
) : IUserService {

    override fun save(t: Author): Author =
            repository.save(t)

    override fun update(id: Long, t: Author): Author {
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

    override fun findAll(): List<Author> =
            repository.findAll().toList()

    override fun findByLogin(login: String): Author? =
            repository.findByLogin(login) ?: throw ResponseStatusException(HttpStatus.NOT_FOUND, "This user does not exist")
}