package edu.mizzou.adoptme.model;


public abstract class Pet implements Comparable<Pet>{
	private String name; 
	private int age; 
	private String species; 
	private AdoptionStatus status; 
	
	public Pet(String name, int age, String species) { 
		//json style. 
		this.name = name; 
		this.age = age; 
		this.species = species; 
		this.status = AdoptionStatus.AVAILABLE; 
	}
	
	
	public abstract String getDetails(); 
	
	public String getName() {
		return name; 
	}
	
	public int getAge() { 
		return age; 
	}
	
	public String getSpecies() { 
		return species; 
	}
	
	public AdoptionStatus getStatus() { 
		return status; 
	}
	
	public void adopt() { 
		this.status = AdoptionStatus.ADOPTED; 
	}
	
	@Override
	public int compareTo(Pet other) { 
		return this.name.compareTo(other.name); 
	}
	
}
