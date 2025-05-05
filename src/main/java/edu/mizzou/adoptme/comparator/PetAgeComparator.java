package edu.mizzou.adoptme.comparator;

import edu.mizzou.adoptme.model.Pet;
import java.util.Comparator;

/**
 * Comparator for sorting Pet objects by age in ascending order.
 */
public class PetAgeComparator implements Comparator<Pet> {
    /**
     * Compares two Pet objects by their age.
     *
     * @param p1 the first pet
     * @param p2 the second pet
     * @return a negative integer, zero, or a positive integer to tell if p1 less than, equal to, or greater than p2
     */
    @Override
    public int compare(Pet p1, Pet p2) {
        return Integer.compare(p1.getAge(), p2.getAge());
    }
}
