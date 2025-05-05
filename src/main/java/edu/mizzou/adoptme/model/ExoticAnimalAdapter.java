package edu.mizzou.adoptme.model;

public class ExoticAnimalAdapter extends Pet {
    private ExoticAnimalDTO exotic;

    public ExoticAnimalAdapter(ExoticAnimalDTO exotic) {
        super(exotic.getExoticName(), exotic.getExoticAge(), exotic.getType(), exotic.getSubSpecies());
        this.exotic = exotic;
    }

    @Override
    public String getDetails() {
        return "I'm an exotic " + exotic.getType() + " (" + exotic.getSubSpecies() + ") named " + exotic.getExoticName() + ", age " + exotic.getExoticAge();
    }
}