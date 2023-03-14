package com.code8.bankingsystem.repository

import com.code8.bankingsystem.models.User
import org.springframework.data.mongodb.repository.MongoRepository

interface UserRepository: MongoRepository<User, String> {
}