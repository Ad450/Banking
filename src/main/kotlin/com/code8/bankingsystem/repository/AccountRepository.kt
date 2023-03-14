package com.code8.bankingsystem.repository

import com.code8.bankingsystem.models.Account
import org.springframework.data.mongodb.repository.MongoRepository

interface AccountRepository : MongoRepository<Account, String> {
}