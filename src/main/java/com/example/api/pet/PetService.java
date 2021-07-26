package com.example.api.pet;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class PetService {
    private final PetRepository petRepository;
    private final ModelMapper modelMapper=new ModelMapper();

    public PetService(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    @Transactional
    public Pet createOrUpdatePet(PetDTO petDTO, Long owner_id){
        Pet pet=modelMapper.map(petDTO,Pet.class);
        Pet newPet=petRepository.save(pet);
        petRepository.setOwnerAndPetId(owner_id, newPet.getId());
        return newPet;
    }

    public List<Pet> getAllPets(){
        return petRepository.findAll();
    }

    public Pet getPetByName(String name){
        return petRepository.getPetByName(name);
    }

    public List<Pet> getPetsByType(String type){
        return petRepository.getPetsByType(type);
    }

    public Pet getPetById(Long id){
        return petRepository.findById(id).orElse(null);
    }

    @Transactional
    public int deletePetById(Long id){
        return petRepository.deletePetById(id);
    }
}
