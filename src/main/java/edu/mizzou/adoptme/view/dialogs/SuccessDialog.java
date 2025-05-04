package edu.mizzou.adoptme.view.dialogs;

import javax.swing.*;

public class SuccessDialog extends JDialog {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SuccessDialog(JFrame parent, String message) {
        super(parent, "Success", true);
        setSize(300, 150);
        setLocationRelativeTo(parent);
        add(new JLabel(message));
    }
}
