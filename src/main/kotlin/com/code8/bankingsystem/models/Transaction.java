package com.code8.bankingsystem.models;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@NoArgsConstructor
@AllArgsConstructor
@Data
@Setter
@Getter
public class Transaction {
    @Id
    private String transactionId;
    private TransactionType transactionType;

}
