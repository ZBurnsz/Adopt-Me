package edu.mizzou.adoptme.model;


//had to add this class to allow for any species of pet because, pet is an abstract class.
public class GenericPetImplementation extends Pet {
    public GenericPetImplementation(String name, int age, String species, AdoptionStatus status, String type) {
        super(name, age, species, type);
        if (status == AdoptionStatus.ADOPTED) adopt();
    }

    @Override
    public String getDetails() {
        return getSpecies() + " named " + getName() + ", age " + getAge();
    }
}
