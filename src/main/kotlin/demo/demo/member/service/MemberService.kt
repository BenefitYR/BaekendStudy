import demo.demo.common.authority.JwtTokenProvider
import demo.demo.common.dto.loginDto



import demo.demo.common.authority.TokenInfo
import demo.demo.common.dto.MemberDtoRequest
import demo.demo.common.status.Role
import demo.demo.member.entity.MemberRole
import demo.demo.member.repository.MemberRepository
import demo.demo.member.repository.MemberRoleRepository
import jakarta.transaction.Transactional
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.stereotype.Service

@Transactional
@Service
class MemberService(
    private val memberRepository: MemberRepository,
    private val memberRoleRepository: MemberRoleRepository,
    private val authenticationManagerBuilder: AuthenticationManagerBuilder

//    val gender: Gender,
   // val memberController: MemberController
) {
    /**
     * 회원 가입
     */
    fun signUp(memberDtoRequest: MemberDtoRequest): String {
        //ID 중복 검사
        var member: demo.demo.member.entity.Member? = memberRepository.findByLoginId(memberDtoRequest.loginId)
        if (member != null) {
            throw demo.demo.common.exception.InvalidInputException("loginId", "이미 등로된 ID 입니다.")
        }

        member = memberDtoRequest.toEntity()

        memberRepository.save(member)

        //회원가입 시 권한 정보도 멤버로 같이 저장?
        val memberRole: MemberRole = MemberRole(null, Role.MEMBER, member)
        memberRoleRepository.save(memberRole)

        return "회원가입이 완료되었습니다."
    }

    /**
     * 로그인 -> 토큰 발행
     */
    fun login(loginDto: loginDto): TokenInfo {
        val authenticationToken = UsernamePasswordAuthenticationToken(loginDto.loginId, loginDto.password)
        val authentication = authenticationManagerBuilder.`object`.authenticate(authenticationToken)

        return JwtTokenProvider.createToken(authentication)
    }
}

