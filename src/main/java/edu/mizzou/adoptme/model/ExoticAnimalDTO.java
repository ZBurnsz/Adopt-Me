package edu.mizzou.adoptme.model;


/**
 * Data Transfer Object for exotic animals from third-party JSON format.
 */
public class ExoticAnimalDTO {
    private String uniqueId;
    private String animalName;
    private String category;
    private String subSpecies;
    private int yearsOld;

    // Required constructor for Gson
    public ExoticAnimalDTO() {}

    /**
     * Gets the name of the exotic animal.
     * @return exotic animal name
     */
    public String getExoticName() {
        return animalName;
    }

    /**
     * Gets the age of the exotic animal.
     * @return exotic animal age
     */
    public int getExoticAge() {
        return yearsOld;
    }

    /**
     * Gets the type/category of the exotic animal.
     * @return exotic animal category
     */
    public String getType() {
        return category;
    }

    /**
     * Gets the unique ID of the exotic animal.
     * @return unique ID
     */
    public String getUniqueId() {
        return uniqueId;
    }

    /**
     * Gets the sub-species of the exotic animal.
     * @return sub-species string
     */
    public String getSubSpecies() {
        return subSpecies;
    }
}