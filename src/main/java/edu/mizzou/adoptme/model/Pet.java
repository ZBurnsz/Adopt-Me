package edu.mizzou.adoptme.model;

/**
 * Abstract base class for all Pet types.
 */

public abstract class Pet implements Comparable<Pet> {
    private String name;
    private int age;
    private String type;
    private String species;
    private AdoptionStatus status;

    /**
     * Constructs a new Pet.
     * @param name the name of the pet
     * @param age the age of the pet
     * @param species the species category (Dog, Cat, etc.)
     * @param type the specific breed or type of the pet
     */
    public Pet(String name, int age, String species, String type) {
        //json style.
        this.name = name;
        this.age = age;
        this.type = type;
        this.species = species;
        this.status = AdoptionStatus.AVAILABLE;
    }

    /**
     * @return type of pet
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the breed/type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Abstract method for detailed pet description.
     * @return details string
     */
    public abstract String getDetails();

    /**
     * @return name of pet
     */
    public String getName() {
        return name;
    }

    /**
     * @return age of pet
     */
    public int getAge() {
        return age;
    }

    /**
     * @return species of pet
     */
    public String getSpecies() {
        return species;
    }

    /**
     * @return adoption status
     */
    public AdoptionStatus getStatus() {
        return status;
    }

    /**
     * Sets adoption status to ADOPTED.
     */
    public void adopt() {
        this.status = AdoptionStatus.ADOPTED;
    }

    /**
     * Compares pets by name.
     * @param other the other pet to compare to
     * @return result of name comparison
     */
    @Override
    public int compareTo(Pet other) {
        return this.name.compareTo(other.name);
    }
}
