package com.example.api.owner;

import com.example.api.pet.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OwnerRepository extends JpaRepository<Owner,Long> {

    @Query(value = "select o from Owner o where o.phoneNumber=:phoneNumber")
    Owner getOwnerByPhoneNumber(String phoneNumber);

    @Query(value = "select o.pet from Owner o where o.id=:id")
    List<Pet> getPetsOfOwner(Long id);

    @Query(nativeQuery = true, value = "select o.* from owner o, owner_pet where o.id=owner_id and pet_id=:id")
    Owner getOwnerByPetId(Long id);

    @Modifying
    @Query(value = "delete from Owner o where o.id=:id")
    int deleteOwnerById(Long id);
}
