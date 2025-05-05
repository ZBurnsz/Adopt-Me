package edu.mizzou.adoptme.model;

public class Cat extends Pet {


	public Cat(String name, int age, String species, String type) {
		super(name, age, "Cat", type);
	}

	@Override
	public String getDetails() {
		return "Meow! My name is " + getName() +", age " + getAge();
	}
	
	
	
	
	
	

}
