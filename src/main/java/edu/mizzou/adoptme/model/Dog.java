package edu.mizzou.adoptme.model;

public class Dog extends Pet {

	public Dog(String name, int age, String species, String type) {
		super(name, age, "Dog", type);
	}

	@Override
	public String getDetails() {
		return "Bark Bark! My name is" + getName() +", age " + getAge();
	}
	
	
	
	
	
	

}
