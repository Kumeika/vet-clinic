package com.example.api.owner;

import com.example.api.pet.Pet;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class OwnerService {

    private final OwnerRepository ownerRepository;
    private final ModelMapper modelMapper=new ModelMapper();

    public OwnerService(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    public Owner createOrUpdateOwner(OwnerDTO ownerDTO){
        Owner owner=modelMapper.map(ownerDTO,Owner.class);
        return ownerRepository.save(owner);
    }

    public List<Owner> getAllOwners(){
        return ownerRepository.findAll();
    }

    public Owner getOwnerById(Long id){
        return ownerRepository.findById(id).orElse(null);
    }

    public Owner getOwnerByPhoneNumber(String phoneNumber){return ownerRepository.getOwnerByPhoneNumber(phoneNumber);}

    public List<Pet> getPetsOfOwner(Long id){return ownerRepository.getPetsOfOwner(id);}

    public Owner getOwnerByPetId(Long id){return ownerRepository.getOwnerByPetId(id);}

    @Transactional
    public int deleteOwnerById(Long id){
        return ownerRepository.deleteOwnerById(id);
    }
}
