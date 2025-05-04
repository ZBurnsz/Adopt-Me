package edu.mizzou.adoptme.view.dialogs;

import javax.swing.*;

public class ErrorDialog extends JDialog {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ErrorDialog(JFrame parent, String errorMessage) {
        super(parent, "Error", true);
        setSize(300, 150);
        setLocationRelativeTo(parent);
        add(new JLabel(errorMessage));
    }
}
