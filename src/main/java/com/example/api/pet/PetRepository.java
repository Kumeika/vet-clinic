package com.example.api.pet;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PetRepository extends JpaRepository<Pet,Long> {

    @Query(value = "select p from Pet p where p.name=:name")
    Pet getPetByName(String name);

    @Query(value = "select p from Pet p where p.type=:type")
    List<Pet> getPetsByType(String type);

    @Modifying
    @Query(value = "delete from Pet p where p.id=:id")
    int deletePetById(Long id);

    @Modifying
    @Query(nativeQuery = true, value = "insert into owner_pet(owner_id,pet_id) values (:owner_id, :pet_id)")
    void setOwnerAndPetId(Long owner_id, Long pet_id);
}
