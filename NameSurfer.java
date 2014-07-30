/*
 * File: NameSurfer.java
 * ---------------------
 * When it is finished, this program will implements the viewer for
 * the baby-name database described in the assignment handout.
 */

import acm.program.*;
import java.awt.event.*;
import javax.swing.*;

public class NameSurfer extends ConsoleProgram implements NameSurferConstants {
	NameSurferGraph Graph;
	JTextField NameField;
	/* Method: init() */
	/**
	 * This method has the responsibility for reading in the data base
	 * and initializing the interactors at the top of the window.
	 */
	public void init() {
	    String GUIButtonLocation = NORTH;
		Graph = new NameSurferGraph();
		int FieldLength = 8;
		NameField = new JTextField(FieldLength);
	    NameField.setActionCommand("Graph");
		add(Graph);
	    add(new JLabel("Name:"), GUIButtonLocation);
	    add(NameField, GUIButtonLocation);
	    add(new JButton("Graph"), GUIButtonLocation);
	    add(new JButton("Clear"), GUIButtonLocation);
	    addActionListeners();
	}

	/* Method: actionPerformed(e) */
	/**
	 * This class is responsible for detecting when the buttons are
	 * clicked, so you will have to define a method to respond to
	 * button actions.
	 */
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		if(cmd == "Graph") {
			String Name = NameField.getText();
			println(Name);
			//NameSurferEntry Entry = new NameSurferEntry(*Fill This in);
			//Graph.addEntry(Entry);
		}
	}
}
