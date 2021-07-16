package com.example.sampleKotlinspringBoot.bo

import com.example.sampleKotlinspringBoot.Ext.toSlug
import java.time.LocalDateTime
import javax.persistence.*

@Entity
class Article(
    var title: String,
    var headline: String,
    var content: String,
    @ManyToOne var author: Author,
    var slug: String = title.toSlug(),
    var addedAt: LocalDateTime = LocalDateTime.now(),
    @Id @GeneratedValue var id: Long? = null)

@Entity
class Author(
    var login: String,
    var firstname: String,
    var lastname: String,
    var description: String? = null,
    @Id @GeneratedValue var id: Long? = null)