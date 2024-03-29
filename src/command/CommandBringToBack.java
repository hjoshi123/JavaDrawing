package command;

import model.DrawModel;
import shapes.Shape;

/**
 * Class that represent command to bring some shape to the back.
 */
public class CommandBringToBack implements Command {
	private DrawModel model;
	private Shape shape;
	private int index;
	
	public CommandBringToBack(DrawModel model, Shape shape) {
		this.model = model;
		this.shape = shape;
	}

	/**
	 * Get index of shape, remove it from that place and add it to the first place.
	 */
	@Override
	public void execute() {
		index =  model.getIndexOf(shape);
		model.removeAtIndex(index);
		model.addToIndex(0, shape);
	}

	/**
	 * Remove shape from first place and return it to the previous (original) position.
	 */
	@Override
	public void unexecute() {
		model.removeAtIndex(0);
		model.addToIndex(index, shape);
	}
}