/* Anthony Lydon - 2497467.
 * 
 * A component class to represent the buttons in the bottom right of the window.
 */

// The necessary import statements for building the GUI.
import java.awt.GridLayout;
import javax.swing.*;

public class ButtonsComponent extends JPanel {

	// Setting up the class variables.

	private JButton spinButton, newGameButton;
	private FruitMachineController controllerObject;

	public ButtonsComponent(FruitMachineController controller) {

		controllerObject = controller;
		spinButton = new JButton("Spin"); // Naming a button
		spinButton.addActionListener(controllerObject); // Adding an action listener to a button.
		newGameButton = new JButton("New Game");
		newGameButton.addActionListener(controllerObject);
		setLayout(new GridLayout(2, 1, 10, 10)); // Setting the spacing between buttons.

		this.add(spinButton); // Adding a button to the ButtonsComponent panel.
		this.add(newGameButton);
		newGameButton.setEnabled(false); // New game button disabled on start
		spinButton.setFont(spinButton.getFont().deriveFont(16.0f)); // Setting the font size of a button.
		newGameButton.setFont(newGameButton.getFont().deriveFont(16.0f));
	}

	// Getters

	public JButton getSpinButton() {
		return spinButton;
	}

	public JButton getNewGameButton() {
		return newGameButton;
	}

}
