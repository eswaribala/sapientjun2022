package com.sapient.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Getter
@ToString
@NoArgsConstructor
@Component
public class Claim {

    private long claimId;
    @Autowired
   // @Qualifier("policy2")
    private Policy policy;

  /*
@Autowired
  public Claim(Policy policy) {

        this.policy = policy;
    }*/

    public void setClaimId(long claimId) {
        this.claimId = claimId;
    }


}
