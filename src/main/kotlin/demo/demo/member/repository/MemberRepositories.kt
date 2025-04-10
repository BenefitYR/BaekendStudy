package demo.demo.member.repository

import demo.demo.member.entity.MemberRole
import org.springframework.data.jpa.repository.JpaRepository


interface MemberRepository : JpaRepository<demo.demo.member.entity.Member, Long> {
    fun findByLoginId(loginId: String): demo.demo.member.entity.Member?
}

interface MemberRoleRepository : JpaRepository<MemberRole, Long>