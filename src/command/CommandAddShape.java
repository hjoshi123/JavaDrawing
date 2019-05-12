package command;

import model.DrawModel;
import shapes.Shape;

/**
 * Class that represent command for add new shape to the draw.
 */
public class CommandAddShape implements Command {
    private Shape shape;
    private DrawModel model;

    public CommandAddShape(Shape shape, DrawModel model) {
        this.shape = shape;
        this.model = model;
    }

    /**
     * Add new shape to the draw.
     */
    @Override
    public void execute() {
        model.add(shape);
    }

    /**
     * Remove previous added shape to the draw.
     */
    @Override
    public void unexecute() {
        model.remove(shape);
    }
}
