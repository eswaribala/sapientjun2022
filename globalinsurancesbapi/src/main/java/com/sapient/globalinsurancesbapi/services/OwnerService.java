package com.sapient.globalinsurancesbapi.services;

import com.sapient.globalinsurancesbapi.models.Owner;
import com.sapient.globalinsurancesbapi.repositories.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OwnerService {
    @Autowired
    private OwnerRepository ownerRepository;

    //insert

    public Owner addOwner(Owner owner){

        return this.ownerRepository.save(owner);
    }

    //select all
    public List<Owner> getAllOwners(){
        return this.ownerRepository.findAll();
    }

    //select by id
    public Owner getOwnerById(long mobileNo){
        return this.ownerRepository.findById(mobileNo).orElse(null);
    }

    //delete
    public boolean deleteOwnerById(long mobileNo){
        this.ownerRepository.deleteById(mobileNo);
        if(this.getOwnerById(mobileNo)==null)
            return true;
        return false;
    }


}
