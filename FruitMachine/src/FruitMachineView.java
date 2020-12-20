/* Anthony Lydon - 2497467.
 * 
 * A class to represent the view; handles the GUI.
 */

// The necessary import statements for building the GUI.

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;

public class FruitMachineView extends JFrame {

	// Setting up the class variables.

	private FruitMachineController controllerObject;
	private FruitMachineModel modelObject;
	private TextComponent textComponent;
	private ButtonsComponent buttonsComponent;
	private CardsComponent cardsComponent;

	
	final int UNIT = 20; // Establishing a constant unit size.

	public FruitMachineView(FruitMachineModel model, FruitMachineController controller) {

		controllerObject = controller;
		modelObject = model;

		// Instantiating the components.
		textComponent = new TextComponent(model);
		cardsComponent = new CardsComponent(model);
		buttonsComponent = new ButtonsComponent(controller);
		JPanel p = new JPanel();

		setDefaultCloseOperation(EXIT_ON_CLOSE); // Closes the window when the users clicks close.
		setTitle("FruitMachine GUI"); // Setting up the title for the window.

		p.setBorder(new EmptyBorder(1 * UNIT, 1 * UNIT, 1 * UNIT, 1 * UNIT)); // Setting an empty border
		add(p); // Adding a main JPanel to the frame.
		addComponentsToPane(p); // Calls a method which adds components to the JPanel.

		pack(); // Sizing the window based on the sizes of the sub components.

	}

	public void addComponentsToPane(Container pane) { // A method to add the components to the JPanel.
		

		pane.setLayout(new GridBagLayout()); // Uses GridBagLayout.
		GridBagConstraints c = new GridBagConstraints(); // Making an instance of the GridBag constraints.

		c.fill = GridBagConstraints.BOTH; // Resizing the components.

		c.gridwidth = 2; // This component is two grid columns long.
		c.gridheight = 1; // This component is one grid row high.
		pane.add(textComponent, c); // Adds the component.

		c.gridy = 1; // This component will be positioned one row down.
		c.gridwidth = 1; // This component is one grid column long.
		c.gridheight = 1; // This component is one grid row high.
		c.insets = new Insets(1 * UNIT, 0, 1 * UNIT, 0); // padding the component.
		pane.add(cardsComponent, c); // Adds the component.

		c.gridx = 1; // This component will be positioned one column to the right
		c.gridy = 1; // This component will be positioned one row down.
		c.insets = new Insets(2 * UNIT, 1 * UNIT, 2 * UNIT, 1 * UNIT); // padding the component.
		pane.add(buttonsComponent, c); // Adds the component.
	}

	public void updateLabelTexts(String message, String statusMessage) { // A method to update the text of the labels.
		textComponent.getCreditsLabel().setText("Balance is " + modelObject.getCredits());
		textComponent.getMessageLabel().setText(message);
		textComponent.getStatusLabel().setText(statusMessage);

	}

	public void updateButtons(boolean canSpin, boolean canNewGame) { // A method to update whether the buttons can be
																		// pressed.
		buttonsComponent.getSpinButton().setEnabled(canSpin);

		buttonsComponent.getNewGameButton().setEnabled(canNewGame);

	}

	public void updateCards() { // A method to update the text on the cards.
		cardsComponent.getCard1().updateCards(modelObject, 0); // First uses a method to check the card name.
		cardsComponent.getCard2().updateCards(modelObject, 1);
		cardsComponent.getCard3().updateCards(modelObject, 2);

		cardsComponent.getCard1().getCardLabel().setText(cardsComponent.getCard1().getLabelText()); // Then updates this
																									// name to the card
																									// on the display.
		cardsComponent.getCard2().getCardLabel().setText(cardsComponent.getCard2().getLabelText());
		cardsComponent.getCard3().getCardLabel().setText(cardsComponent.getCard3().getLabelText());
	}

	public ButtonsComponent getButtonsComponent() {
		return buttonsComponent;
	}

}
