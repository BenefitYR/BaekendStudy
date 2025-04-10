package demo.demo.common.dto

import com.fasterxml.jackson.annotation.JsonProperty
import demo.demo.common.annotation.ValidEnum
import demo.demo.common.status.Dormitory
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Pattern
import java.time.LocalDate
import java.time.format.DateTimeFormatter

data class MemberDtoRequest(
    private val id: Long?,

    @field:NotBlank
    @JsonProperty("loginId")
    private val _loginId: String?,

    @field:NotBlank
    @field:Pattern(
        regexp = "^(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[!@#\$%^&*])[a-zA-Z0-9!@#\$%^&*]{8,20}\$",
        message = "영문, 숫자, 특수문자를 포함한 8~20 자리로 입력해주세요"
    )
    @JsonProperty("password")
    private val _password: String?,

    @field:NotBlank
    @JsonProperty("name")
    private val _name: String?,

    @field:NotBlank
    @field:Email
    @JsonProperty("email")
    private val _email: String?,

    @field:NotBlank
    @field:ValidEnum(enumClass = Dormitory::class, message = "고운(A,B,C), 경상(11,12,13,14) 중 본인의 기숙사 하나를 택하세요.")
    @JsonProperty("dormitory")
    private val _dormitory: String?,

//    @field:NotBlank
//    @field:Pattern (
//        regexp = "^([12]\\d{3}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01]))$",
//        message = "날짜형식(YYYY-MM-DD)을 확인해주세요"
//    )
//    @JsonProperty("birthDate")
//    private val _birthDate: String?,


//    @field:NotBlank
//    @field:ValidEnum(enumClass = Gender::class, message = "MAN 이나 WOMAN 중 하나를 선택해주세요.")
//    @JsonProperty("gender")
//    private val _gender: String?,



) {
    val loginId: String
        get() = _loginId!!

    val password: String
        get() = _password!!

    val name: String
        get() = _name!!

//    val birthDate: LocalDate
//        get() = _birthDate!!.toLocalDate()
//    val gender: Gender
//        get() = Gender.valueOf(_gender!!)

    val email: String
        get() = _email!!

    val dormitory: String
        get() = dormitory!!

    private fun String.toLocalDate(): LocalDate =
        LocalDate.parse(this, DateTimeFormatter.ofPattern("yyyy-MM-dd"))

    fun toEntity(): demo.demo.member.entity.Member =
        demo.demo.member.entity.Member(id, loginId, password, name, email)
}

data class loginDto (
    @field:NotBlank
    @JsonProperty("loginId")
    private val _loginId: String?,

    @field:NotBlank
    @JsonProperty("password")
    private val _password: String?,
) {
    val loginId: String
        get() = _loginId!!
    val password: String
        get() = _password!!
}