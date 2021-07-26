package com.example.api.pet;

import com.example.api.exceptions.PetNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class PetRestController {

    private final PetService petService;

    public PetRestController(PetService petService) {
        this.petService = petService;
    }

    @PostMapping("/pets")
    public ResponseEntity<Pet> createOrUpdatePet(@RequestBody PetDTO pet, @RequestParam Long owner_id){
        return new ResponseEntity<>(petService.createOrUpdatePet(pet,owner_id), HttpStatus.OK);
    }

    @GetMapping("/pets")
    public ResponseEntity<List<Pet>> getPets(@RequestParam(required = false)String type){
        List<Pet> pets;
        if (type==null){
            pets=petService.getAllPets();
            if (pets.isEmpty()) throw new PetNotFoundException("There are no registered pets.");
        } else {
            pets=petService.getPetsByType(type);
            if (pets.isEmpty())throw new PetNotFoundException("Pets not found for "+type+".");
            return new ResponseEntity<>(pets,HttpStatus.OK);
        }
        return new ResponseEntity<>(pets,HttpStatus.OK);
    }

    @GetMapping("/pets/info/{name}")
    public ResponseEntity<Pet> getPetByName(@PathVariable String name){
        Pet pet= petService.getPetByName(name);
        if (pet==null){
            throw new PetNotFoundException("Pet with name "+name+" not found.");
        }
        return new ResponseEntity<>(pet,HttpStatus.OK);
    }

    @GetMapping("/pets/{id}")
    public ResponseEntity<Pet> getPetById(@PathVariable Long id){
        Pet pet= petService.getPetById(id);
        if (pet==null){
            throw new PetNotFoundException("Pet with id "+id+" not found.");
        }
        return new ResponseEntity<>(pet,HttpStatus.OK);
    }

    @DeleteMapping("pets/{id}/delete")
    public ResponseEntity<?> deletePetById(@PathVariable Long id){
        if (petService.deletePetById(id)>0){
            return new ResponseEntity<>(petService.deletePetById(id),HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
}
