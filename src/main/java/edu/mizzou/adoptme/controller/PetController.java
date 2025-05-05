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

public class PetController {
    private final Shelter<Pet> shelter = new Shelter<>();
    private JTable petTable;
    
    //loads pets from pets.json 
    public PetController() {
    	//pets.json 
        List<Pet> loadedPets = JsonUtils.loadPetsFromJson("src/main/resources/pets.json");
        if (loadedPets != null) loadedPets.forEach(shelter::addPet);
        //exotic_anmials.json 
        List<Pet> exotics = JsonUtils.loadExoticsFromJson("src/main/resources/exotic_animals.json");
        if (exotics != null) exotics.forEach(shelter::addPet);
    }
    
    //creates table
    public void setPetTable(JTable table) {
        this.petTable = table;
    }

    public DefaultTableModel getPetTableModel() {
        String[] columns = {"Name", "Age", "Species", "Adopted"};
        
        DefaultTableModel model = new DefaultTableModel(columns, 0);

        for (Pet pet : shelter.getPets()) {
            model.addRow(new Object[]{
                    pet.getName(),
                    pet.getAge(),
                    pet.getSpecies(),
                    pet.getStatus() == AdoptionStatus.ADOPTED ? "Yes" : "No"
            });
        }
        return model;
    }

    public Pet getSelectedPet() {
        int selectedRow = petTable.getSelectedRow();
        
        if (selectedRow == -1) {
        	return null;
        }
        return shelter.getPets().get(selectedRow);
    }
    
    //allows you to add a pet into the table. 
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

    public void removeSelectedPet() {
        Pet selected = getSelectedPet();
        
        if (selected != null) {
            shelter.removePet(selected);
            JOptionPane.showMessageDialog(null, selected.getName() + " has been removed!");
            refreshTable();
        }
    }

    //view details of the pet author: turner
    public void getDetails(JFrame parentFrame) {
        Pet selectedPet = getSelectedPet();
        if (selectedPet != null) {
            PetDetailsDialog dialog = new PetDetailsDialog(parentFrame, selectedPet);
            dialog.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(parentFrame, "Please select a pet first.", "No Selection", JOptionPane.WARNING_MESSAGE);
        }
    }

    public void sortPets(String criteria) {
        switch (criteria) {
            case "Sort by Age" -> shelter.getPets().sort(new PetAgeComparator());
            case "Sort by Species" -> shelter.getPets().sort(new PetSpeciesComparator());
            case "Sort by Name" -> Collections.sort(shelter.getPets()); // uses compareTo()
        }
        refreshTable();
    }

    private void refreshTable() {
        if (petTable != null) {
            petTable.setModel(getPetTableModel());
        }
    }

    public void savePetsToFile() {
        String timestamp = new SimpleDateFormat("yyyyMMdd HHmmss").format(new Date());
        JsonUtils.savePetsToJson(shelter.getPets(), "src/main/resources/" + timestamp + "_pets.json");
        JOptionPane.showMessageDialog(null, "Pet list saved.");
    }
}
