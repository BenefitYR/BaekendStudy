package com.example.demo.member.service

import com.example.demo.common.status.Gender
import com.example.demo.member.controller.MemberController

class service(
    val gender: Gender,
    val memberController: MemberController
) {
    fun test(){
        val a = memberController.abc()
        println(a)
        val b = "MAN"
    }
}