package edu.mizzou.adoptme.view.panels;

import edu.mizzou.adoptme.controller.PetController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SortingPanel extends JPanel {
    private static final long serialVersionUID = 1L;

    public SortingPanel(PetController controller) {
    	//not sure if this work correctly, allows for drop down ATM. 
        JComboBox<String> sortOptions = new JComboBox<>(new String[]{"Sort by Name", "Sort by Age", "Sort by Species"});
        
        sortOptions.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selected = (String) sortOptions.getSelectedItem();
                controller.sortPets(selected);
            }
        });
        add(sortOptions);
    }
}