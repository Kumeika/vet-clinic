package com.example.api.owner;

import com.example.api.exceptions.OwnerNotFoundException;
import com.example.api.exceptions.PetNotFoundException;
import com.example.api.pet.Pet;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class OwnerRestController {

    private final OwnerService ownerService;

    public OwnerRestController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @PostMapping("/owners")
    public ResponseEntity<Owner> createOrUpdateOwner(@RequestBody OwnerDTO owner){
        return new ResponseEntity<>(ownerService.createOrUpdateOwner(owner), HttpStatus.OK);
    }

    @GetMapping("/owners")
    public ResponseEntity<?> getOwners(@RequestParam(required = false) String phoneNumber) {
        if(phoneNumber != null) {
            Owner owner = ownerService.getOwnerByPhoneNumber(phoneNumber);
            if (owner == null) {
                throw new OwnerNotFoundException("Owner with phone number: "+phoneNumber+" not found.");
            }
            return new ResponseEntity<>(owner, HttpStatus.OK);
        }
        List<Owner> owners = ownerService.getAllOwners();
        if (owners.isEmpty()){
            throw new OwnerNotFoundException("There are no registered owners.");
        }
        return new ResponseEntity<>(owners,HttpStatus.OK);
    }

    @GetMapping("/owners/{id}")
    public ResponseEntity<Owner> getOwnerById(@PathVariable Long id){
        Owner owner= ownerService.getOwnerById(id);
        if (owner==null){
            throw new OwnerNotFoundException("Owner with id "+id+" not found.");
        }
        return new ResponseEntity<>(owner,HttpStatus.OK);
    }

    @GetMapping("/owners/{id}/pets")
    public ResponseEntity<List<Pet>> getPetsOfOwner(@PathVariable Long id){
        List<Pet> pets=ownerService.getPetsOfOwner(id);
        if (pets.isEmpty()){
            throw new PetNotFoundException("Owner with id "+id+" has no registered pets.");
        }
        return new ResponseEntity<>(pets,HttpStatus.OK);
    }

    @GetMapping("/pets/{id}/owner")
    public ResponseEntity<Owner> getOwnerByPetId(@PathVariable Long id){
        Owner owner= ownerService.getOwnerByPetId(id);
        if (owner==null){
            throw new OwnerNotFoundException("Pet with id "+id+" has no owner.");
        }
        return new ResponseEntity<>(owner,HttpStatus.OK);
    }

    @DeleteMapping("owners/{id}/delete")
    public ResponseEntity<?> deleteOwnerById(@PathVariable Long id){
        if (ownerService.deleteOwnerById(id)>0){
            return new ResponseEntity<>(ownerService.deleteOwnerById(id),HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
}
