package observer;

import frames.DrawFrame;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class DrawObserver implements PropertyChangeListener {
    DrawFrame frame;

    public DrawObserver(DrawFrame frame) {
        this.frame = frame;
    }

    /**
     * Method that add listener to some button and enable it.
     *
     * @param button Represent button which need to be updated.
     * @param adapter Represent adapter for that button.
     */
    public void addListener(JButton button, MouseAdapter adapter) {
        if (!button.isEnabled()) {
            button.setEnabled(true);
            button.addMouseListener(adapter);
        }
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}
