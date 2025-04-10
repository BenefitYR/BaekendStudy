package demo.demo.member.controller

import MemberService
import demo.demo.common.authority.TokenInfo
import demo.demo.common.dto.MemberDtoRequest
import demo.demo.member.service.MemberService
import demo.demo.common.dto.BaseResponse
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/api/member")
@RestController
class MemberController(
private val memberService: MemberService
) {
    /**
     * 회원가입
     */
    @PostMapping("/signup") //회원가입 API
    fun signUp(@RequestBody @Valid memberDtoRequest: MemberDtoRequest): BaseResponse<Unit> {
        val resultMsg: String = memberService.signUp(memberDtoRequest)
        return BaseResponse(message = resultMsg)
    }
    /**
     *
    로그인
     */
    @PostMapping("/login")
    fun login(@RequestBody @Valid loginDto: LoginDto): BaseResponse<TokenInfo> {
        val tokenInfo = memberService.login(loginDto)
        return BaseResponse(data = tokenInfo)
    }
}
