package edu.mizzou.adoptme.model;


/**
* Represents a Cat pet.
*/
public class Cat extends Pet {
	/**
	 * Constructs a new Cat object.
	 * @param name the name of the cat
	 * @param age the age of the cat
	 * @param species the species ("Cat")
	 * @param type the type (e.g., breed)
	 */
	public Cat(String name, int age, String species, String type) {
		super(name, age, "Cat", type);
	}

	/**
	 * Returns details specific to a Cat.
	 * @return details string
	 */
	@Override
	public String getDetails() {
		return "Meow! My name is " + getName() +", age " + getAge();
	}
}