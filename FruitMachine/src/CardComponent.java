/* Anthony Lydon - 2497467.
 * 
 * A component class to represent a card.
 */

// The necessary import statements for building the GUI.

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.*;

public class CardComponent extends JPanel {

	// Setting up the class variables.

	private FruitMachineModel modelObject;
	private JLabel cardLabel;
	private String labelText;

	public CardComponent(FruitMachineModel model, int cardNum) { // A constructor
		modelObject = model;
		updateCards(model, cardNum); // Calls a method to update the card labels.
		setBackground(Color.YELLOW); // Setting the background colour.
		setLayout(new BorderLayout());

		cardLabel = new JLabel(labelText);

		cardLabel.setFont(cardLabel.getFont().deriveFont(16.0f)); // Setting the cards font size.
		this.add(cardLabel);

		// Aligning the label to the centre of the CardComponent.
		cardLabel.setHorizontalAlignment(SwingConstants.CENTER);
		cardLabel.setVerticalAlignment(SwingConstants.CENTER);

	}

	public void updateCards(FruitMachineModel model, int cardNum) { // A method which when given a card, translates the
																	// card's value into a card name and displays it on
																	// the card's label.
		if (model.getCards()[cardNum] == 0)
			labelText = "Joker";
		if (model.getCards()[cardNum] == 1)
			labelText = "Ace";
		if (model.getCards()[cardNum] == 2)
			labelText = "King";
		if (model.getCards()[cardNum] == 3)
			labelText = "Queen";
		if (model.getCards()[cardNum] == 4)
			labelText = "Jack";

	}

	public String getLabelText() {
		return labelText;
	}

	public JLabel getCardLabel() {
		return cardLabel;
	}

}
