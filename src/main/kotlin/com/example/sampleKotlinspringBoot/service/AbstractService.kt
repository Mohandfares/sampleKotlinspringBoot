package com.example.sampleKotlinspringBoot.service

interface AbstractService<T, ID> {

    fun save(t: T): T
    fun update(id: ID,t: T): T
    fun delete(id: ID): String
    fun findAll(): List<T>
}