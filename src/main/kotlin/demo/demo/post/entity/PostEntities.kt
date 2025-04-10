package demo.demo.post.entity

import demo.demo.member.entity.Member
import jakarta.persistence.*

@Entity
@Table(name = "post")
class Post(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long? = null,

    @Column(nullable = false, length = 100)
    val title: String,

    @Column(nullable = false, columnDefinition = "TEXT")
    val content: String,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    val author: Member, // 작성자


)