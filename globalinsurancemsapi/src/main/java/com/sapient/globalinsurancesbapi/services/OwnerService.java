package com.sapient.globalinsurancesbapi.services;

import com.sapient.globalinsurancesbapi.exceptions.RecordFoundException;
import com.sapient.globalinsurancesbapi.models.Owner;
import com.sapient.globalinsurancesbapi.repositories.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OwnerService {
    @Autowired
    private OwnerRepository ownerRepository;

    //insert

    public Owner addOwner(Owner owner){
     if(this.getOwnerById(owner.getMobileNo()) == null)
         return this.ownerRepository.save(owner);
     else
         throw new RecordFoundException("Owner Already Exists");

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

    //update

    public Owner updateOwnerEmail(long mobileNo,String email){

        Owner owner= this.getOwnerById(mobileNo);
        if(owner!=null){
            owner.setEmail(email);
            this.ownerRepository.save(owner);
            return owner;
        }
        return null;
    }


}
