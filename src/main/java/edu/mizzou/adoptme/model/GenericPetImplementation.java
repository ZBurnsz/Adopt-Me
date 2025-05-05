package edu.mizzou.adoptme.model;
/**
 * Generic implementation of a Pet to allow any species.
 * Used when species does not match Dog, Cat, or Rabbit.
 */
//pet helper class
public class GenericPetImplementation extends Pet {

    /**
     * Constructs a generic pet implementation.
     * @param name the name of the pet
     * @param age the age of the pet
     * @param species the species of the pet
     * @param status the adoption status
     * @param type the type or breed of the pet
     */
    public GenericPetImplementation(String name, int age, String species, AdoptionStatus status, String type) {
        super(name, age, species, type);
        if (status == AdoptionStatus.ADOPTED) adopt();
    }

    /**
     * Returns a basic detail description of the pet.
     * @return formatted string with species, name, and age
     */
    @Override
    public String getDetails() {
        return getSpecies() + " named " + getName() + ", age " + getAge();
    }
}
