package edu.mizzou.adoptme;

import edu.mizzou.adoptme.controller.PetController;
import edu.mizzou.adoptme.view.MainFrame;

import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            PetController controller = new PetController(); 
            MainFrame frame = new MainFrame(controller);    
            frame.setVisible(true);
        });
    }
}
