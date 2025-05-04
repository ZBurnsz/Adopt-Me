package edu.mizzou.adoptme.view.panels;

import edu.mizzou.adoptme.controller.PetController;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class PetListPanel extends JPanel {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private JTable petTable;
    private PetController controller;

    public PetListPanel(PetController controller) {
        this.controller = controller;
        setLayout(new BorderLayout());

        petTable = new JTable();
        controller.setPetTable(petTable);
        refreshTable();

        add(new JScrollPane(petTable), BorderLayout.CENTER);
    }

    public void refreshTable() {
        DefaultTableModel model = controller.getPetTableModel();
        petTable.setModel(model);
    }
}
