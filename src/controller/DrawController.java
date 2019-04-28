package controller;

import javax.swing.*;
import java.awt.*;

/**
 * <h2>Class representing the controller in MVC pattern</h2>
 *
 * Called by {@link views.DrawView} when user clicks something and act depending on the command (usually update
 * {@link model.DrawModel}).
 */
public class DrawController {
    private Color edgeColor = Color.BLACK;
    private Color interiorColor = Color.WHITE;
    private Color choosenEdgeColor;
    private Color choosenInteriorColor;

    /**
     * User clicked to choose edge color, show {@inheritDoc JColorChooser}.
     *
     * @return Color that user choose.
     */
    public Color btnEdgeColorClicked() {
        choosenEdgeColor = JColorChooser.showDialog(null, "Colors pallete", edgeColor);
        if (choosenEdgeColor != null) {
            if (choosenEdgeColor.equals(Color.WHITE)) {
                JOptionPane.showMessageDialog(null, "Background is white :D");
                return null;
            }
            edgeColor = choosenEdgeColor;
            return edgeColor;
        }
        return choosenEdgeColor;
    }

    /**
     * <h3>User clicked to choose area color, show {@inheritDoc JColorChooser}.</h3>
     *
     * @return Color that user choose.
     */
    public Color btnInteriorColorClicked() {
        choosenInteriorColor = JColorChooser.showDialog(null, "Colors pallete", interiorColor);
        if (choosenInteriorColor != null) {
            interiorColor = choosenInteriorColor;
            return interiorColor;
        }
        return choosenEdgeColor;
    }
}
