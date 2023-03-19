package com.code8.bankingsystem.models;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.Date;

@Document
@NoArgsConstructor
@AllArgsConstructor
@Data
@Setter
@Getter
public class User {
    @Id
    private String userId;
    @Indexed(unique = true)
    private String email;
    private String name;
    @CreatedDate
    private Date createdAt;
    @LastModifiedDate
    private Date updatedAt;
    @DocumentReference
    private Account account;
}
