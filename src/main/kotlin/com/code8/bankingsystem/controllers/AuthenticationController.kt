package com.code8.bankingsystem.controllers

import com.code8.bankingsystem.dto.AuthDTO
import com.code8.bankingsystem.models.Account
import com.code8.bankingsystem.models.User
import com.code8.bankingsystem.repository.UserRepository
import com.code8.bankingsystem.services.AuthenticationService
import com.code8.bankingsystem.utils.Mapper
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.core.findOne
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController()
@RequestMapping("/api/auth")
class AuthenticationController(
    private val authenticationService: AuthenticationService,
    private val userRepository: UserRepository,
    private val mongoTemplate: MongoTemplate,
    private val mapper: Mapper
) {
    @PostMapping("/text")
    fun createUser(@RequestBody body: AuthDTO):AuthDTO {
        val (name, email) = body;
        var query = Query();
        query.addCriteria(Criteria.where("email").`is`(email));
        var user: User? = mongoTemplate.findOne(query, User::class.java);
        if(user != null) {
            return mapper.userToDTO(user);
        }else {
            val newUser =  userRepository.save(mapper.dtoToUser(body))
            return mapper.userToDTO(newUser);
        }
    }
}

