package com.sapient.models;

import lombok.*;
import org.bson.codecs.pojo.annotations.BsonId;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Claim {


    private long claimId;
    private long policyNo;
    private long claimAmount;
    private LocalDate claimDate;


}
