package com.example.demo.member.entity

import com.example.demo.common.status.Gender
import jakarta.persistence.*
import java.time.LocalDate


@Entity
@Table(
    uniqueConstraints = [UniqueConstraint(name = "uk_mamber_login_id", columnNames = ["loginId"])]
)
class Member (
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long? = null,

    @Column(nullable = false, length = 30, updatable = false)
    val loginId: String,

    @Column(nullable = false, length = 100)
    val password: String,

    @Column(nullable = false, length = 10)
    val name: String,

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    val birtDate: LocalDate,

    @Column(nullable = false, length = 5)
    @Enumerated(EnumType.STRING)
    val gender: Gender,

    @Column(nullable = false, length = 30)
    val email: String,
)