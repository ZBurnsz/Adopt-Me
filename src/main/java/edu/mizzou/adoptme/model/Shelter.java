package edu.mizzou.adoptme.model;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Shelter<T extends Pet> {
	
    private List<T> pets;

    public Shelter() {
        pets = new ArrayList<>();
    }

    public void addPet(T pet) {
        pets.add(pet);
    }

    public void removePet(T pet) {
        pets.remove(pet);
    }
    
    //for modifying 
    public List<T> getPets() {
    	return pets; 
    }
    //for viewing stuff 
    public List<T> getUnmodifiablePets() {
        return Collections.unmodifiableList(pets);
    }


    public void adoptPet(T pet) {
        if (pet.getStatus() == AdoptionStatus.ADOPTED) {
            throw new IllegalStateException("Pet has already been adopted.");
        }
        pet.adopt();
    }
}