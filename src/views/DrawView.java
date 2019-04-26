package views;

import model.DrawModel;
import shapes.Shape;

import javax.swing.*;
import java.awt.*;

/**
 * @author hemantj
 * Represent View in MVC Architectural form
 */
public class DrawView extends JPanel {
    private static final long serialVersionUID = 1L;
    private DrawModel model;

    public DrawView() {}

    /**
     * When {@link DrawModel} change, paint changes triggered by {@link controller.DrawController} to draw.
     */
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        if (model != null) {
            for (Shape shape : model.getAll()) shape.draw(g);
        }
    }

    public void setModel(DrawModel model) {
        this.model = model;
    }
}
