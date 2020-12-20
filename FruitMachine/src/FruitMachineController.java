/* Anthony Lydon - 2497467.
 * 
 * A class to represent the controller; handles user input.
 */

// The necessary import statements for building the interactive elements.

import java.awt.event.*;

public class FruitMachineController implements ActionListener {

	// Setting up the class variables.

	private FruitMachineView viewObject;
	private FruitMachineModel modelObject;

	public FruitMachineController(FruitMachineModel model) {
		modelObject = model;

	}

	public void setView(FruitMachineView view) {
		viewObject = view;
	}

	public void actionPerformed(ActionEvent e) { // Handling events.
		if (e.getSource() == viewObject.getButtonsComponent().getSpinButton()) { // Checking if the spin button was
																					// clicked.
			modelObject.spin(); // Calls the spin method from the model class.
			viewObject.updateLabelTexts(modelObject.getMessage(), modelObject.getStatusMessage()); // Calls a method to
																									// update the text
																									// in the JLables.
			viewObject.updateButtons(!modelObject.isGameOver(), modelObject.isGameOver()); // Calls a method which
																							// updates whether the
																							// buttons are enabled.
			viewObject.updateCards(); // Calls a method to update the JLables for the cards.

		} else if (e.getSource() == viewObject.getButtonsComponent().getNewGameButton()) { // Checking if the new game
																							// button was clicked.
			modelObject.newGame(); // Calls the new game method from the model class.
			viewObject.updateLabelTexts(modelObject.getMessage(), modelObject.getStatusMessage()); // Calls a method to
																									// update the text
																									// in the JLables.
			viewObject.updateButtons(true, false); // Calls a method which updates whether the buttons are enabled.
			viewObject.updateCards(); // Calls a method to update the JLables for the cards
		}
	}
}
