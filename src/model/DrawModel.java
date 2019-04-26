package model;

import shapes.Shape;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 * Represent model in MVC architectural pattern. Contains application data.
 */
public class DrawModel implements Serializable {
    private static final long serialVersionUID = 1L;
    private List<Shape> shapes;

    public DrawModel() {
        shapes = new ArrayList<>();
    }

    /**
     * Add new shape.
     *
     * @param shape Represent shape which will be added.
     */
    public void add(Shape shape) {
        shapes.add(shape);
    }

    /**
     * Add new shape to specified index.
     * @param index Represent index on which shape will be added.
     * @param shape Represent shape which will be added.
     */
    public void addToIndex(int index, Shape shape) {
        shapes.add(index, shape);
    }

    /**
     * Add multiple shapes to list of shapes.
     *
     * @param shapes Elements that are be added.
     */
    public void addMultiple(ArrayList<Shape> shapes) {
        this.shapes.addAll(shapes);
    }

    /**
     * Remove shape from list of shapes.
     *
     * @param shape Shape to be removed.
     */
    public void remove(Shape shape) {
        shapes.remove(shape);
    }

    /**
     * Remove shape at specified index.
     *
     * @param index Represent index of shape that will be removed.
     */
    public void removeAtIndex(int index) {
        shapes.remove(index);
    }

    /**
     * Remove multiple shapes from list of shapes.
     *
     * @param shapes Shapes to be removed.
     */
    public void removeMultiple(ArrayList<Shape> shapes) {
        this.shapes.removeAll(shapes);
    }

    /**
     * Remove all shapes from list of shapes.
     */
    public void removeAll() {
        shapes.clear();
    }

    public Shape getByIndex(int index) {
        return shapes.get(index);
    }

    public int getIndexOf(Shape shape) {
        return shapes.indexOf(shape);
    }

    public List<Shape> getAll() {
        return shapes;
    }
}
