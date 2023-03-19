package com.code8.bankingsystem.models;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Document
@NoArgsConstructor
@AllArgsConstructor
@Data
@Setter
@Getter
public class Deposit {
    @MongoId(FieldType.OBJECT_ID)
    private String depositId;
    private Integer amount;
    @DocumentReference
    private Account to;
    @DocumentReference
    private Account from;
    private TransactionType transactionType = TransactionType.DEPOSIT;
}


//  val senderId: String,
//    val amount: Int,
//    val to: String? = "code8",
//    val transactionId: String,
//    val transactionType: TransactionType