package demo.demo.common.status

enum class Gender(val desc: String) {
    MAN("남"),
    WOMAN("여")
}

enum class ResultCode(val msg: String) {
    SUCCESS("정상 처리 되었습니다."),
    ERROR("에러가 발생했습니다.")
}

enum class Dormitory(val desc: String) {
    GounA("고운A"),
    GounB("고운B"),
    GounC("고운C"),
    Kyung11("경상11"),
    Kyung12("경상12"),
    Kyung13("경상13"),
    Kyung14("경상14"),
}

enum class Role {
    MEMBER
}