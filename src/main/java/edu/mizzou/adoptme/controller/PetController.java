
package edu.mizzou.adoptme.controller;

import edu.mizzou.adoptme.model.*;
import edu.mizzou.adoptme.utils.JsonUtils;
import edu.mizzou.adoptme.comparator.PetAgeComparator;
import edu.mizzou.adoptme.comparator.PetSpeciesComparator;
import edu.mizzou.adoptme.view.dialogs.AddPetDialog;
import edu.mizzou.adoptme.view.dialogs.PetDetailsDialog;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Collections;

/**
 * Controller class for handling operations related to the pets. 
 * Acts as the intermediary between the model and view in the MVC architecture.
 */
public class PetController {
    private final Shelter<Pet> shelter = new Shelter<>();
    private JTable petTable;

    /**
     * loads pets from pets.json 
     */
    public PetController() {
        //pets.json 
        List<Pet> loadedPets = JsonUtils.loadPetsFromJson("src/main/resources/pets.json");
        if (loadedPets != null) loadedPets.forEach(shelter::addPet);
        //exotic_anmials.json 
        List<Pet> exotics = JsonUtils.loadExoticsFromJson("src/main/resources/exotic_animals.json");
        if (exotics != null) exotics.forEach(shelter::addPet);
    }

    /**
     * creates table
     * @param table JTable to be managed by the controller
     */
    public void setPetTable(JTable table) {
        this.petTable = table;
    }

    /**
     * Generates and returns the table model for the pet table
     * @return a DefaultTableModel with pet data
     */
    public DefaultTableModel getPetTableModel() {
        String[] columns = {"Name", "Age", "Species", "Type", "Adopted"};

        DefaultTableModel model = new DefaultTableModel(columns, 0) {
            private static final long serialVersionUID = 1L;
            //stops cell editing from table view. 
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; 
            }
        };

        for (Pet pet : shelter.getUnmodifiablePets()) {
            model.addRow(new Object[]{
                    pet.getName(),
                    pet.getAge(),
                    pet.getSpecies(),
                    pet.getType(),
                    pet.getStatus() == AdoptionStatus.ADOPTED ? "Yes" : "No"
            });
        }

        return model;
    }

    /**
     * gets the selected pet in the table
     * @return the Pet object corresponding to the selected table row
     */
    public Pet getSelectedPet() {
        int selectedRow = petTable.getSelectedRow();

        if (selectedRow == -1) {
            return null;
        }
        return shelter.getUnmodifiablePets().get(selectedRow);
    }

    /**
     * allows you to add a pet into the table. 
     * @param dialog input dialog for adding a new pet
     */
    public void addPetFromDialog(AddPetDialog dialog) {
        try {
            String name = dialog.getNameInput();
            int age = dialog.getAgeInput();
            String species = dialog.getSpeciesInput();
            String type = dialog.getTypeInput();

            if (name.isEmpty() || age < 0) {
                throw new IllegalArgumentException("Invalid pet data");
            }

            Pet newPet;
            switch (species) {
                case "Dog" -> newPet = new Dog(name, age, species, type);
                case "Cat" -> newPet = new Cat(name, age, species, type);
                case "Rabbit" -> newPet = new Rabbit(name, age, species, type);
                default -> newPet = new GenericPetImplementation(name, age, species, AdoptionStatus.AVAILABLE, type);
            }

            shelter.addPet(newPet);
            refreshTable();

        } catch (Exception error) {
            JOptionPane.showMessageDialog(null, "Invalid input: " + error.getMessage());
        }
    }

    /**
     * adopts a selected pet from the list
     */
    public void adoptSelectedPet() {
        Pet selected = getSelectedPet();

        if (selected == null) {
            JOptionPane.showMessageDialog(null, "Please select a pet to adopt.");
            return;
        }

        if (selected.getStatus() == AdoptionStatus.ADOPTED) {
            JOptionPane.showMessageDialog(null, "This pet is already adopted :)");
        } else {
            selected.adopt();

            JOptionPane.showMessageDialog(null, selected.getName() + " has been adopted!");
            refreshTable();
        }
    }

    /**
     * removes the selected pet from the table
     */
    public void removeSelectedPet() {
        Pet selected = getSelectedPet();

        if (selected != null) {
            shelter.removePet(selected);

            JOptionPane.showMessageDialog(null, selected.getName() + " has been removed!");
            refreshTable();
        }
    }

    /**
     * view details of the pet author: turner 
     * @param parentFrame parent JFrame
     */
    public void getDetails(JFrame parentFrame) {
        Pet selectedPet = getSelectedPet();

        if (selectedPet != null) {
            PetDetailsDialog dialog = new PetDetailsDialog(parentFrame, selectedPet);
            dialog.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(parentFrame, "Please select a pet first.", "No Selection", JOptionPane.WARNING_MESSAGE);
        }
    }

    /**
     * sorts the pet list based on criteria and updates the table
     * @param criteria String for sort choice
     */
    public void sortPets(String criteria) {
        //System.out.println("Sorting pets by: " + criteria); 

        switch (criteria) {
            case "Sort by Age" -> shelter.getPets().sort(new PetAgeComparator());
            case "Sort by Species" -> shelter.getPets().sort(new PetSpeciesComparator());
            case "Sort by Name" -> Collections.sort(shelter.getPets()); // uses compareTo()
        }
        refreshTable();
    }

    /**
     * refreshes the JTable with current pet list
     */
    private void refreshTable() {
        if (petTable != null) {
            petTable.setModel(getPetTableModel());
        }
    }

    /**
     * saves the current pet list to a JSON file with timestamp layout from PDF 
     */
    public void savePetsToFile() {
        String timestamp = new SimpleDateFormat("yyyyMMdd HHmmss").format(new Date());
        JsonUtils.savePetsToJson(shelter.getUnmodifiablePets(), "src/main/resources/" + timestamp + "_pets.json");
        JOptionPane.showMessageDialog(null, "Pet list saved.");
    }
}