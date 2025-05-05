package edu.mizzou.adoptme.model;


/**
 * Adapter class to convert ExoticAnimalDTO to a Pet.
 */
public class ExoticAnimalAdapter extends Pet {
    private ExoticAnimalDTO exotic;

    /**
     * Constructs an adapter wrapping the exotic animal DTO.
     * @param exotic the exotic animal data object
     */
    public ExoticAnimalAdapter(ExoticAnimalDTO exotic) {
        super(exotic.getExoticName(), exotic.getExoticAge(), exotic.getType(), exotic.getSubSpecies());
        this.exotic = exotic;
    }

    /**
     * Returns details for the exotic animal.
     * @return details string
     */
    @Override
    public String getDetails() {
        return "I'm an exotic " + exotic.getType() + " (" + exotic.getSubSpecies() + ") named " + exotic.getExoticName() + ", age " + exotic.getExoticAge();
    }
}