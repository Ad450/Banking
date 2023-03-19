package com.code8.bankingsystem

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.mongodb.config.EnableMongoAuditing

@SpringBootApplication
@EnableMongoAuditing
class BankingSystemApplication

fun main(args: Array<String>) {
	runApplication<BankingSystemApplication>(*args)
}
