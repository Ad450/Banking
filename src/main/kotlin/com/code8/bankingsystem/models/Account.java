package com.code8.bankingsystem.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.joda.time.DateTime;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;
import org.springframework.web.service.annotation.DeleteExchange;

@Document
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Account {
    @Id
    private String accountId;
    @DocumentReference
    private User user;
    private Integer balance;
    private AccountType accountType;
    @CreatedDate
    private DateTime createdAt;
    @LastModifiedDate
    private DateTime updatedAt;

}


//- accountId
//        - userId
//        - account type
//        - balance
//        - createdAt
//        - updatedAt
//        - deletedAt