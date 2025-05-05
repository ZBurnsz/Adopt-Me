package edu.mizzou.adoptme.model;

public class Rabbit extends Pet{

	public Rabbit(String name, int age, String species, String type) {
		super(name, age, "Rabbit", type);
		}

	@Override
	public String getDetails() {
		return "Grunt! My name is" + getName() + ", age " + getAge();
	}
	
	

}
