package com.sapient.globalinsurancesbapi.services;

import com.sapient.globalinsurancesbapi.models.FullName;
import com.sapient.globalinsurancesbapi.models.Gender;
import com.sapient.globalinsurancesbapi.models.Owner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class FakeOwnerService {


    public static List<Owner> getAllOwners(){
        List<Owner> ownerList=new ArrayList<Owner>();

        for(int i=0;i<100;i++){

            ownerList.add(new Owner(new Random().nextInt(),new FullName("param"+i,"","Bala"),
                  Gender.FEMALE,"param"+i+"@gmail.com"));
        }
        return ownerList;

    }
}
