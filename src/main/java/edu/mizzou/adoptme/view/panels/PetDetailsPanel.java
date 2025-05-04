package edu.mizzou.adoptme.view.panels;

import javax.swing.*;

public class PetDetailsPanel extends JPanel {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PetDetailsPanel() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        
        add(new JLabel("Pet Name"));
        add(new JTextField(20));

        add(new JLabel("Pet Age"));
        add(new JTextField(20));

        add(new JButton("Save"));
    }
}
