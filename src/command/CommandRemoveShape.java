package command;

import java.util.ArrayList;
import model.DrawModel;
import shapes.Shape;

/**
 * Class that represent command for remove existing shape from the draw. 
 */
public class CommandRemoveShape implements Command {
	private ArrayList<Shape> shapes;
	private Shape shape;
	private DrawModel model;
	
	public CommandRemoveShape(ArrayList<Shape> shapes, DrawModel model) {
		this.shapes = shapes;
		this.model = model;
	}
	
	public CommandRemoveShape(Shape shape, DrawModel model) {
		this.shape = shape;
		this.model = model;	
	}

	/**
	 * Remove shape from the draw.
	 */
	@Override
	public void execute() { 
		if (shapes != null) model.removeMultiple(shapes);
		else model.remove(shape);
	}

	/**
	 * Return previous deleted shape to the draw.
	 */
	@Override
	public void unexecute() {
		if (shapes != null) model.addMultiple(shapes);
		else model.add(shape);
	}
	
	/**
	 * Return number of deleted shapes to undo/redo multiple commands from log at once if multiple shapes are deleted at once.
	 * @return size of the shapes array
	 */
	public int getSize() {
		return shapes.size();
	}
}