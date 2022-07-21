package com.sapient.globalinsurancesbapi.conrtollers;

import com.sapient.globalinsurancesbapi.models.Owner;
import com.sapient.globalinsurancesbapi.services.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OwnerController {
    @Autowired
    private OwnerService ownerService;

    //@PostMapping("")
    public ResponseEntity<?> addOwner(@RequestBody Owner owner){

        Owner ownerObj=this.ownerService.addOwner(owner);
        if(ownerObj!=null){
            return ResponseEntity.status(HttpStatus.OK).body(ownerObj);
        }
        else
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Owner Data Not Added");
    }

}
