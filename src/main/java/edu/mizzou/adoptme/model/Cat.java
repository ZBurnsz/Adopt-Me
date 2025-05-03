package edu.mizzou.adoptme.model;

public class Cat extends Pet {


	public Cat(String name, int age, String species) {
		super(name, age, "Cat");
	}

	@Override
	public String getDetails() {
		return "Meow! My name is " + getName() +", age " + getAge();
	}
	
	
	
	
	
	

}
