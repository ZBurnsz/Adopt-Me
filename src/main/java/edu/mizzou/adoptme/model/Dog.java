package edu.mizzou.adoptme.model;

public class Dog extends Pet {

	public Dog(String name, int age, String species) {
		super(name, age, "Dog");
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getDetails() {
		// TODO Auto-generated method stub
		return "Bark Bark! My name is" + getName() +", age " + getAge();
	}
	
	
	
	
	
	

}
