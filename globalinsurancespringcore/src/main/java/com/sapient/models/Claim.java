package com.sapient.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

@Getter
@NoArgsConstructor
public class Claim {

    private long claimId;
    private Policy policy;

    @Autowired
    public Claim(Policy policy) {

        this.policy = policy;
    }

    public void setClaimId(long claimId) {
        this.claimId = claimId;
    }


}
