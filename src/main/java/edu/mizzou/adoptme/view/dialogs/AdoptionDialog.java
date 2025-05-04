package edu.mizzou.adoptme.view.dialogs;

import javax.swing.*;

public class AdoptionDialog extends JDialog {
	
	
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AdoptionDialog(JFrame parent) {
        super(parent, "Adopt Pet", true);
        setSize(300, 200);
        setLocationRelativeTo(parent);
        add(new JLabel("Pet Adopted!"));
    }
}
