package com.sapient.claimkafkaconsumerapi.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;


@Table("PSPolicy")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class PSPolicy {
    @PrimaryKey("PolicyNo")
    private long policyNo;
    @Column("PolicyName")
    private String policyName;
    @Column("FromDate")
    private String fromDate;
    @Column("ToDate")
    private String toDate;
    @Column("SumInsured")
    private long sumInsured;
}
