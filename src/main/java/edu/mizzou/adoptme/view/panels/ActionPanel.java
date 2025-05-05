package edu.mizzou.adoptme.view.panels;

import edu.mizzou.adoptme.controller.PetController;
import edu.mizzou.adoptme.view.dialogs.AddPetDialog;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionPanel extends JPanel {
    private static final long serialVersionUID = 1L;

    public ActionPanel(PetController controller) {
    	//add pet button 
        JButton addButton = new JButton("Add Pet");
        
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddPetDialog dialog = new AddPetDialog(null);
                dialog.setVisible(true);
                if (dialog.isConfirmed()) {
                    controller.addPetFromDialog(dialog);
                }
            }
        });
        add(addButton);
        
        //adopt button 
        JButton adoptButton = new JButton("Adopt Pet");
        adoptButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.adoptSelectedPet();
            }
        });
        add(adoptButton);

        //remove pet button
        JButton removeButton = new JButton("Remove Pet");
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.removeSelectedPet();
            }
        });
        add(removeButton);

        //view details button
        JButton viewDetailsButton = new JButton("View Details");
        viewDetailsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.getDetails((JFrame) SwingUtilities.getWindowAncestor(viewDetailsButton));
            }
        });
        add(viewDetailsButton);

        //save button
        JButton saveButton = new JButton("Save");
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.savePetsToFile();
            }
        });
        add(saveButton);
    }
}
