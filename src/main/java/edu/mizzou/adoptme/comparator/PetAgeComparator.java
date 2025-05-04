package edu.mizzou.adoptme.comparator;

import edu.mizzou.adoptme.model.Pet;
import java.util.Comparator;

public class PetAgeComparator implements Comparator<Pet> {
    @Override
    public int compare(Pet p1, Pet p2) {
        return Integer.compare(p1.getAge(), p2.getAge());
    }
}

