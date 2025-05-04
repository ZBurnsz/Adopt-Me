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

    //getters matching expected Pet interface from json file
    public String getExoticName() {
        return animalName;
    }

    public int getExoticAge() {
        return yearsOld;
    }

    public String getType() {
        return category;
    }

    public String getUniqueId() {
        return uniqueId;
    }

    public String getSubSpecies() {
        return subSpecies;
    }
}
