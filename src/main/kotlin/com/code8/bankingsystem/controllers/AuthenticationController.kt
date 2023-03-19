package com.code8.bankingsystem.controllers

import com.code8.bankingsystem.dto.AuthDTO
import com.code8.bankingsystem.models.Account
import com.code8.bankingsystem.models.User
import com.code8.bankingsystem.repository.AccountRepository
import com.code8.bankingsystem.repository.UserRepository
import com.code8.bankingsystem.services.AuthService
import com.code8.bankingsystem.utils.Mapper
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType

@RestController()
@RequestMapping("/api/auth")
class AuthenticationController(
    private val authService: AuthService,
    private val userRepository: UserRepository,
    private val mapper: Mapper,
    private val accountRepository: AccountRepository
) {

    @PostMapping("/user")
    fun createUser(@RequestBody body: AuthDTO ): Map<String, Any> {
        val (email,name)= body;
        if (authService.findUserByEmail(email).isPresent) throw Exception("user already exists")
        val user = authService.createUser(email, name)
        val newUser = userRepository.save(user)
        authService.createAccount(newUser, 0)
        return mapOf("success" to true, "id" to authService.getIdOfUser(newUser));
    }
}

