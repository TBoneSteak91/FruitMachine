/* Anthony Lydon - 2497467.
 * 
 * A component class to represent the grid of cards in the bottom left of the window.
 */

// The necessary import statements for building the GUI.

import java.awt.GridLayout;

import javax.swing.*;

public class CardsComponent extends JPanel {

	// Setting up the class variables.

	private CardComponent card1;
	private CardComponent card2;
	private CardComponent card3;
	private FruitMachineModel modelObject;

	public CardsComponent(FruitMachineModel model) {
		setLayout(new GridLayout(1, 3, 10, 10)); // Setting up the layout and spacing of the cards.
		modelObject = model;

		// Instantiating the cards.
		card1 = new CardComponent(model, 0);
		card2 = new CardComponent(model, 1);
		card3 = new CardComponent(model, 2);

		// adding the cards to the CardsComponent panel.
		this.add(card1);
		this.add(card2);
		this.add(card3);

	}

	public CardComponent getCard1() {
		return card1;
	}

	public CardComponent getCard2() {
		return card2;
	}

	public CardComponent getCard3() {
		return card3;
	}

}
