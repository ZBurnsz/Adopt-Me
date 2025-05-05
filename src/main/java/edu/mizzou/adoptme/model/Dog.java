package edu.mizzou.adoptme.model;


/**
 * Represents a Dog pet.
 */
public class Dog extends Pet {

	/**
	 * Constructs a new Dog object.
	 * @param name the name of the dog
	 * @param age the age of the dog
	 * @param species the species ("Dog")
	 * @param type the type (e.g., breed)
	 */
	public Dog(String name, int age, String species, String type) {
		super(name, age, "Dog", type);
	}

	/**
	 * Returns details specific to a Dog.
	 * @return details string
	 */
	@Override
	public String getDetails() {
		return "Bark Bark! My name is" + getName() +", age " + getAge();
	}
}