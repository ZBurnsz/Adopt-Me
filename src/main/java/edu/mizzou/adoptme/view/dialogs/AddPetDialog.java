package edu.mizzou.adoptme.view.dialogs;

import javax.swing.*;
import java.awt.*;

public class AddPetDialog extends JDialog {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JTextField nameField;
    private JTextField ageField;
    private JTextField typeField;
    private JTextField speciesBox;
    private boolean confirmed = false;

    /* 
     * Styling for addPet we can change this around to our liking. 
     */
    public AddPetDialog(JFrame parent) {
        super(parent, "Add New Pet", true);
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridLayout(4, 2, 10, 10));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        nameField = new JTextField();
        ageField = new JTextField();
        speciesBox = new JTextField();
        typeField = new JTextField();

        inputPanel.add(new JLabel("Name:"));
        inputPanel.add(nameField);
        inputPanel.add(new JLabel("Age:"));
        inputPanel.add(ageField);
        inputPanel.add(new JLabel("Species:"));
        inputPanel.add(speciesBox);
        inputPanel.add(new JLabel("Type:"));
        inputPanel.add(typeField);
       

        JPanel buttonPanel = new JPanel();
        JButton okBtn = new JButton("OK");
        JButton cancelBtn = new JButton("Cancel");
        buttonPanel.add(okBtn);
        buttonPanel.add(cancelBtn);

        okBtn.addActionListener(e -> {
            confirmed = true;
            dispose();
        });

        cancelBtn.addActionListener(e -> dispose());

        add(inputPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
        pack();
        setLocationRelativeTo(parent);
    }

    public boolean isConfirmed() {
        return confirmed;
    }

    public String getNameInput() {
        return nameField.getText().trim();
    }

    public int getAgeInput() {
        try {
            return Integer.parseInt(ageField.getText().trim());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    public String getSpeciesInput() {
        return (String) speciesBox.getText().trim();
    }
    
    public String getTypeInput() {
    	return typeField.getText().trim();
    }
}
