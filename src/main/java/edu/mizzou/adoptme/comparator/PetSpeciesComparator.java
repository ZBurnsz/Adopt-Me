package edu.mizzou.adoptme.comparator;

import edu.mizzou.adoptme.model.Pet;
import java.util.Comparator;

public class PetSpeciesComparator implements Comparator<Pet> {
    @Override
    public int compare(Pet p1, Pet p2) {
        return p1.getClass().getSimpleName().compareTo(p2.getClass().getSimpleName());
    }
}
