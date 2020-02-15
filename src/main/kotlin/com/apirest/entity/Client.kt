package com.apirest.entity

import org.hibernate.annotations.CreationTimestamp
import java.time.LocalDateTime
import javax.persistence.*
import javax.validation.constraints.Email
import javax.validation.constraints.Size

@Entity
@Table(name = "client")
data class Client
(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long = 0,

        @Column(nullable = false)
        @get:Size(min = 2, max = 50)
        var name: String = "",
        var alias: String = "",

        @field:Email(message = "Format of email is incorrect")
        @Column(unique = true, nullable = false)
        @get:Size(min = 4, max = 50)
        var email: String = "",

        @Column(name = "create_at")
        @CreationTimestamp
        var createAt: LocalDateTime = LocalDateTime.now()
)