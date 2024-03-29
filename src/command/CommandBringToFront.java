package command;

import model.DrawModel;
import shapes.Shape;

/**
 * Class that represent command to bring some shape to the front.
 */
public class CommandBringToFront implements Command {
	private DrawModel model;
	private Shape shape;
	private int size;
	private int index;
	
	public CommandBringToFront(DrawModel model, Shape shape, int size) {
		this.model = model;
		this.shape = shape;
		this.size = size;
	}

	/**
	 * Get index of shape, remove it from that place and add it to the last place.
	 */
	@Override
	public void execute() {
		index =  model.getIndexOf(shape);
		model.removeAtIndex(index);
		model.addToIndex(size, shape);
	}

	/**
	 * Remove shape from last place and return it to the previous (original) position.
	 */
	@Override
	public void unexecute() {
		model.removeAtIndex(size);
		model.addToIndex(index, shape);
	}
}