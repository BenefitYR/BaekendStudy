package demo.demo.common.authority

data class TokenInfo (
    val grantType: String, // 권한 인증 타입
    val accessType: String, // 실제 검증할 토큰
)