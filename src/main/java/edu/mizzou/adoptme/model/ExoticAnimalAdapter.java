package edu.mizzou.adoptme.model;

public class ExoticAnimalAdapter extends Pet {
    private ExoticAnimalDTO exotic;

    public ExoticAnimalAdapter(ExoticAnimalDTO exotic) {
        super(exotic.getExoticName(), exotic.getExoticAge(), exotic.getType());
        this.exotic = exotic;
    }

    @Override
    public String getDetails() {
        return "I'm an exotic " + exotic.getType() + " named " + exotic.getExoticName() + ", age " + exotic.getExoticAge();
    }
}