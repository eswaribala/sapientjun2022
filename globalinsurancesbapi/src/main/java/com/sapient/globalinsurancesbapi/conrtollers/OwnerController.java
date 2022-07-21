package com.sapient.globalinsurancesbapi.conrtollers;

import com.sapient.globalinsurancesbapi.models.Owner;
import com.sapient.globalinsurancesbapi.services.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/owners")
public class OwnerController {
    @Autowired
    private OwnerService ownerService;

    @PostMapping({"/v1.0"})
    @CrossOrigin("*")
    public ResponseEntity<?> addOwner(@Valid @RequestBody Owner owner){

        Owner ownerObj=this.ownerService.addOwner(owner);
        if(ownerObj!=null){
            return ResponseEntity.status(HttpStatus.OK).body(ownerObj);
        }
        else
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Owner Data Not Added");
    }

    @GetMapping({"/v1.0"})
    @CrossOrigin("*")
    public List<Owner> getAllOwners(){
        return this.ownerService.getAllOwners();
    }

    @GetMapping({"/v1.0/{mobileNo}"})
    @CrossOrigin("*")
    public ResponseEntity<?> getOwnerByMobileNo(@PathVariable("mobileNo") long mobileNo){
        Owner ownerObj=this.ownerService.getOwnerById(mobileNo);
        if(ownerObj!=null){
            return ResponseEntity.status(HttpStatus.OK).body(ownerObj);
        }
        else
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Owner Data Not found");
    }

    @DeleteMapping({"/v1.0/{mobileNo}"})
    @CrossOrigin("*")
    public ResponseEntity<?> deleteOwnerByMobileNo(@PathVariable("mobileNo") long mobileNo){

        if(this.ownerService.deleteOwnerById(mobileNo)){
            return ResponseEntity.status(HttpStatus.OK).body("Owner removed from database....");
        }
        else
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Owner Data Not found");
    }


    @PutMapping({"/v1.0/{mobileNo}"})
    @CrossOrigin("*")
    public ResponseEntity<?> updateOwnerByMobileNo(@PathVariable("mobileNo") long mobileNo,
                                                   @RequestParam(name = "email") String email){
        Owner owner=this.ownerService.updateOwnerEmail(mobileNo,email);

        if(owner!=null){
            return ResponseEntity.status(HttpStatus.OK).body(owner);
        }
        else
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Owner Data Not found");
    }
}
