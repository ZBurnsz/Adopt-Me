package edu.mizzou.adoptme.view.dialogs;

import edu.mizzou.adoptme.model.Pet;

import javax.swing.*;
import java.awt.*;

/**
 * A dialog that displays the details of a selected pet.
 */
public class PetDetailsDialog extends JDialog {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PetDetailsDialog(JFrame parent, Pet pet) {
        super(parent, "Pet Details", true);
        setLayout(new BorderLayout());
        setSize(300, 250);
        setLocationRelativeTo(parent);

        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new GridLayout(5, 1, 10, 10));
        infoPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        infoPanel.add(new JLabel("Name: " + pet.getName()));
        infoPanel.add(new JLabel("Age: " + pet.getAge()));
        infoPanel.add(new JLabel("Species: " + pet.getClass().getSimpleName()));
        infoPanel.add(new JLabel("Adopted: " + (pet.getStatus())));

        add(infoPanel, BorderLayout.CENTER);

        // Close button
        JPanel buttonPanel = new JPanel();
        JButton closeButton = new JButton("Close");
        buttonPanel.add(closeButton);
        add(buttonPanel, BorderLayout.SOUTH);

        closeButton.addActionListener(e -> dispose());
    }
}
