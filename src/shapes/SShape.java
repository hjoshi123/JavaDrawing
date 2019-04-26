package shapes;

import java.awt.Color;
import java.awt.Graphics;

/**
 * Abstract class that must implement all shapes with surface.
 */
public abstract class SShape extends Shape {
    private static final long serialVersionUID = 1L;
    private Color interiorColor = Color.WHITE;

    /**
     * Abstract method that must implement all shapes with surface to fill their interior.
     *
     * @param shapeForFillUp object of Graphics shape to be filled
     */
    public abstract void fillUpShape(Graphics shapeForFillUp);

    public Color getInteriorColor() {
        return interiorColor;
    }

    public void setInteriorColor(Color interiorColor) {
        this.interiorColor = interiorColor;
    }
}
