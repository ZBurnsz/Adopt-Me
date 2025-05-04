package edu.mizzou.adoptme.model;

public class GenericPetImplementation extends Pet {
    public GenericPetImplementation(String name, int age, String species, AdoptionStatus status) {
        super(name, age, species);
        if (status == AdoptionStatus.ADOPTED) adopt();
    }

    @Override
    public String getDetails() {
        return getSpecies() + " named " + getName() + ", age " + getAge();
    }
}
