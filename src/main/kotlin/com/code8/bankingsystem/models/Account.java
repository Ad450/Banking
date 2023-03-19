package com.code8.bankingsystem.models;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.*;

import java.util.Date;

@Document
@NoArgsConstructor
@AllArgsConstructor
@Data
@Setter
@Getter
public class Account {
    @MongoId(FieldType.OBJECT_ID)
    private String accountId;
    @DocumentReference
    private User user;
    @Field(targetType = FieldType.STRING)
    private AccountType accountType;
    private Integer balance;
    @CreatedDate
    private Date createdAt;
    @LastModifiedDate
    private Date updatedAt;

}


