package com.sapient.globalinsurancesbapi.conrtollers;

import com.sapient.globalinsurancesbapi.models.Owner;
import com.sapient.globalinsurancesbapi.services.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/owners")
public class OwnerController {
    @Autowired
    private OwnerService ownerService;

    @PostMapping({"/v1.0"})
    public ResponseEntity<?> addOwner(@RequestBody Owner owner){

        Owner ownerObj=this.ownerService.addOwner(owner);
        if(ownerObj!=null){
            return ResponseEntity.status(HttpStatus.OK).body(ownerObj);
        }
        else
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Owner Data Not Added");
    }

    @GetMapping({"/v1.0"})
    public List<Owner> getAllOwners(){
        return this.ownerService.getAllOwners();
    }

}
