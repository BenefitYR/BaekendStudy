package demo.demo.post.dto

import demo.demo.member.entity.Member

data class PostDtos (
    val title: String,
    val content: String,
    val author: Member
)

data class PostRequestDto (
    val title: String,
    val content: String,
)

data class PostResponseDto (
    val id: Long,
    val title: String,
    val content: String,
    val author: Member,
)