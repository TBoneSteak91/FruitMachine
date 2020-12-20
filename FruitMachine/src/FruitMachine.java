/* Anthony Lydon - 2497467.
 * 
 * A class containing the main method.
 */

public class FruitMachine {

	public static void main(String[] args) {
		// Instantiating the three main objects: model, controller and view.
		FruitMachineModel model = new FruitMachineModel();
		FruitMachineController controller = new FruitMachineController(model);
		FruitMachineView view = new FruitMachineView(model, controller);
		controller.setView(view);
		view.setVisible(true); // Making the window visible.

	}

}
