package edu.mizzou.adoptme.model;

/**
 * Represents a Rabbit pet.
 */
public class Rabbit extends Pet {

    /**
     * Constructs a new Rabbit object.
     * @param name the name of the rabbit
     * @param age the age of the rabbit
     * @param species the species ("Rabbit")
     * @param type the type or breed of the rabbit
     */
    public Rabbit(String name, int age, String species, String type) {
        super(name, age, "Rabbit", type);
    }

    /**
     * Returns details specific to a Rabbit.
     * @return details string
     */
    @Override
    public String getDetails() {
        return "Grunt! My name is" + getName() + ", age " + getAge();
    }
}
