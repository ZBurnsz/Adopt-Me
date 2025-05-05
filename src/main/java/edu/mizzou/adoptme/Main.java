package edu.mizzou.adoptme;

import edu.mizzou.adoptme.controller.PetController;
import edu.mizzou.adoptme.view.MainFrame;

import javax.swing.SwingUtilities;

/**
 * Main class to launch adopt-me Pet Adoption Center application.
 * Initializes the PetController and the MainFrame.
 */
public class Main {
    /**
     * The entry point of the application.
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            PetController controller = new PetController(); 
            MainFrame frame = new MainFrame(controller);    
            frame.setVisible(true);
        });
    }
}
