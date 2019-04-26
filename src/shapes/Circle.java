package shapes;

import java.awt.Color;
import java.awt.Graphics;

/**
 * Class that represent circle shape.
 */
public class Circle extends SShape {
    private static final long serialVersionUID = 1L;
    private Point center;
    private int radius;

    // Empty default Constructor
    public Circle() {}

    public Circle(Point center, int r, Color edgeColor, Color interiorColor) {
        this.center = center;
        this.radius = r;
        setColor(edgeColor);
        setInteriorColor(interiorColor);
    }

    @Override
    public void fillUpShape(Graphics shapeForFillUp) {
        shapeForFillUp.setColor(getInteriorColor());
        shapeForFillUp.fillOval(center.getXcoordinate() - radius + 1, center.getYcoordinate() - radius + 1,
                2 * radius - 2, 2 * radius - 2);
    }

    /**
     * Draw circle on canvas
     *
     * @param graphics object of Graphics class to draw
     */
    @Override
    public void draw(Graphics graphics) {
        graphics.setColor(getColor());
        graphics.drawOval(center.getXcoordinate() - radius, center.getYcoordinate() - radius, 2 * radius,
                2 * radius);
        fillUpShape(graphics);
        if (!isSelected()) selected(graphics);
    }

    /**
     * Select the circle
     * @param graphics object of Graphics class to draw
     */
    @Override
    public void selected(Graphics graphics) {
        new Line(new Point(center.getXcoordinate(), center.getYcoordinate() - radius),
                new Point(center.getXcoordinate(), center.getYcoordinate() + radius)).selected(graphics);

        new Line(new Point(center.getXcoordinate() - radius, center.getYcoordinate()),
                new Point(center.getXcoordinate() + radius, center.getYcoordinate())).selected(graphics);
    }

    /**
     * Print cicle values.
     */
    @Override
    public String toString() {
        return "Circle: radius=" + radius + "; x=" + center.getXcoordinate() + "; y=" + center.getYcoordinate() + "; " +
                "edge color=" + getColor().toString().substring(14).replace('=', '-') + "; area color="
                + getInteriorColor().toString().substring(14).replace('=', '-');
    }

    /**
     * Determine if two circles are equal by center and radius.
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Circle) {
            Circle circle = (Circle) obj;
            return center.equals(circle.getCenter()) && radius == circle.getRadius();
        }
        return false;
    }

    /**
     * Comapre two circles by radius
     * @return difference in radius of circles
     */
    @Override
    public int compareTo(Shape shape) {
        if (shape instanceof Circle) return radius - ((Circle) shape).getRadius();
        return 0;
    }

    /**
     * Move center to mentioned coordinates
     */
    @Override
    public void moveTo(int xCoordinate, int yCoordinate) {
        center.moveTo(xCoordinate, yCoordinate);
    }

    /**
     * Determine if circle contains click.
     *
     * @param xCoordinate Represent x coordinate of user click.
     * @param yCoordinate Represent y coordinate of user click.
     * @return Boolean which indicate if circle contains click.
     */
    public boolean containsClick(int xCoordinate, int yCoordinate) {
        return new Point(xCoordinate, yCoordinate).distance(getCenter()) <= radius;
    }

    /**
     * Create new instance of this circle.
     */
    public Circle clone() {
        return new Circle(center.clone(), radius, getColor(), getInteriorColor());
    }

    public Point getCenter() {
        return center;
    }

    public void setCenter(Point center) {
        this.center = center;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }
}
