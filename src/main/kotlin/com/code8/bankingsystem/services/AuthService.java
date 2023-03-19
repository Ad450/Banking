package com.code8.bankingsystem.services;

import com.code8.bankingsystem.models.Account;
import com.code8.bankingsystem.models.AccountType;
import com.code8.bankingsystem.models.User;
import com.code8.bankingsystem.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {

    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    MongoTemplate mongoTemplate;
    public Account createAccount(User user , Integer balance){
        final Account acc = new Account();
        acc.setBalance(balance);
        acc.setUser(user);
        acc.setAccountType(AccountType.SAVINGS);
        accountRepository.save(acc);
        return acc;
    }

    public User createUser(String email, String name){
        User user =  new User();
        user.setEmail(email);
        user.setName(name);
        return user;
    }

    public String getIdOfUser(User user){
        return user.getUserId();
    }

    public Optional<User> findUserByEmail(String email){
        Query query = new Query();
        query.addCriteria(Criteria.where("email").is(email));
        return Optional.ofNullable(mongoTemplate.findOne(query, User.class));
    }
}
