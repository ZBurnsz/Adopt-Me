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
	
    /**
     *@return name of pet
     */
	public String getName() {
		return name; 
	}
	
    /**
     *@return age of pet 
     */
	public int getAge() { 
		return age; 
	}
	
    /**
     *@return species of pet
     */
	public String getSpecies() { 
		return species; 
	}
	
    /**
     *@return adopted or not status
     */
	public AdoptionStatus getStatus() { 
		return status; 
	}
	
    /**
     *@return sets adoption status to be addopted
     */
	public void adopt() { 
		this.status = AdoptionStatus.ADOPTED; 
	}
	
    /**
     *@param other
     *@return sets adoption status to be addopted
     */
	@Override
	public int compareTo(Pet other) { 
		return this.name.compareTo(other.name); 
	}
	
}
