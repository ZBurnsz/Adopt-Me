package edu.mizzou.adoptme.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Generic Shelter class that manages a collection of pets.
 * @param <T> the type of pet, must extend Pet
 */
public class Shelter<T extends Pet> {

    private List<T> pets;

    /**
     * Constructs an empty Shelter.
     */
    public Shelter() {
        pets = new ArrayList<>();
    }

    /**
     * Adds a pet to the shelter.
     * @param pet the pet to add
     */
    public void addPet(T pet) {
        pets.add(pet);
    }

    /**
     * Removes a pet from the shelter.
     * @param pet the pet to remove
     */
    public void removePet(T pet) {
        pets.remove(pet);
    }

    /**
     * Gets the modifiable list of pets.
     * for modifying
     * @return the list of pets
     */
    public List<T> getPets() {
        return pets;
    }

    /**
     * Gets an unmodifiable view of the pet list.
     * for viewing stuff
     * @return an unmodifiable list of pets
     */
    public List<T> getUnmodifiablePets() {
        return Collections.unmodifiableList(pets);
    }

    /**
     * Marks a pet as adopted if not already adopted.
     * @param pet the pet to adopt
     * @throws IllegalStateException if the pet is already adopted
     */
    public void adoptPet(T pet) {
        if (pet.getStatus() == AdoptionStatus.ADOPTED) {
            throw new IllegalStateException("Pet has already been adopted.");
        }
        pet.adopt();
    }
}
