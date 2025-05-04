package edu.mizzou.adoptme.view;

import edu.mizzou.adoptme.controller.PetController;
import edu.mizzou.adoptme.view.panels.ActionPanel;
import edu.mizzou.adoptme.view.panels.PetListPanel;
import edu.mizzou.adoptme.view.panels.SortingPanel;

import javax.swing.*;
import java.awt.*;


/*
 * 
 * We can change this to mess with the look of the GUI 
 * this is a base layout for now. 
 */
public class MainFrame extends JFrame {
    private static final long serialVersionUID = 1L;

    private PetController controller;
    private PetListPanel petListPanel;
    private SortingPanel sortingPanel;
    private ActionPanel actionPanel;

    public MainFrame(PetController controller) {
        this.setController(controller);
        setTitle("Adopt Me - Pet Adoption Center");
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(800, 600));
        setLayout(new BorderLayout(10, 10));

        petListPanel = new PetListPanel(controller);
        sortingPanel = new SortingPanel(controller);
        actionPanel = new ActionPanel(controller);

        add(sortingPanel, BorderLayout.NORTH);
        add(petListPanel, BorderLayout.CENTER);
        add(actionPanel, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null);
    }

    //getters and setters for controller. 
    public void refreshPetList() {
        petListPanel.refreshTable();
    }

	public PetController getController() {
		return controller;
	}

	public void setController(PetController controller) {
		this.controller = controller;
	}
}
