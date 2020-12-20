/* Anthony Lydon - 2497467.
 * 
 * A component class to represent the text labels at the top half of the window.
 */

// The necessary import statements for building the GUI.

import java.awt.GridLayout;
import javax.swing.*;

public class TextComponent extends JPanel {

	// Setting up the class variables.

	private FruitMachineModel modelObject;
	private JLabel creditsLabel, messageLabel, statusLabel;

	public TextComponent(FruitMachineModel model) { // Constructor, setting up the initial values of the labels.

		modelObject = model;
		
		// Instantiating the components.
		creditsLabel = new JLabel("Balance is " + modelObject.getCredits());
		messageLabel = new JLabel("Welcome!");
		statusLabel = new JLabel(" ");
		setLayout(new GridLayout(3, 1, 0, 20)); // Setting up the layout and spacing of the labels.

		// Adding the labels to the TextComponent panel.
		this.add(creditsLabel);
		this.add(messageLabel);
		this.add(statusLabel);

		// Setting the font sizes for the JLables.
		creditsLabel.setFont(creditsLabel.getFont().deriveFont(16.0f));
		messageLabel.setFont(messageLabel.getFont().deriveFont(16.0f));
		statusLabel.setFont(statusLabel.getFont().deriveFont(16.0f));

	}

	// Getters.

	public JLabel getCreditsLabel() {
		return creditsLabel;
	}

	public JLabel getMessageLabel() {
		return messageLabel;
	}

	public JLabel getStatusLabel() {
		return statusLabel;
	}

}
