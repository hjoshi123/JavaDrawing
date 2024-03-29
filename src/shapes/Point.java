package shapes;

import java.awt.*;

/**
 * Class that represent point shape.
 */
public class Point extends Shape {
    private static final long serialVersionUID = 1L;
    private int xCoordinate;
    private int yCoordinate;

    public Point() {}

    public Point(int xCoordinate, int yCoordinate) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
    }

    public Point(int xCoordinate, int yCoordinate, Color color) {
        this(xCoordinate, yCoordinate);
        setColor(color);
    }

    /**
     * Draw point on canvas
     *
     * @param graphics object of Graphics class to draw
     */
    @Override
    public void draw(Graphics graphics) {
        graphics.setColor(getColor());
        graphics.drawLine(xCoordinate - 2, yCoordinate, xCoordinate + 2, yCoordinate);
        graphics.drawLine(xCoordinate, yCoordinate + 2, xCoordinate, yCoordinate - 2);
        if (isSelected()) selected(graphics);
    }

    /**
     * Determine if two points are equal depends on their coordinates.
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Point) {
            Point point = (Point) obj;
            return xCoordinate == point.getXcoordinate() && yCoordinate == point.getYcoordinate();
        }
        return false;
    }

    /**
     * Select point.
     *
     * @param graphics object of Graphics class to draw
     */
    public void selected(Graphics graphics) {
        graphics.setColor(Color.BLUE);
        graphics.drawRect(xCoordinate - 3, yCoordinate - 3, 6, 6);
    }

    /**
     * Determine if this point contains user click.
     *
     * @param xCoordinate Represent x coordinate of user click.
     * @param yCoordinate Represent y coordinate of user click.
     * @return Boolean indicating if this point contain user click.
     */
    @Override
    public boolean containsClick(int xCoordinate, int yCoordinate) {
        return new Point(xCoordinate, yCoordinate).distance(this) <= 2;
    }

    /**
     * Print point values.
     *
     * @return String
     */
    @Override
    public String toString() {
        return "Point: x=" + xCoordinate + "; y=" + yCoordinate + "; color=" + getColor().toString().
                substring(14).replace('=', '-');
    }

    /**
     *  Compare two points depend on their distance.
     *
     * @param shape instance of Shape class
     * @return distance between two points
     */
    @Override
    public int compareTo(Shape shape) {
        if (shape instanceof Point) {
            Point startCoordinates = new Point(0, 0);
            return (int) (distance(startCoordinates) - ((Point) shape).distance(startCoordinates));
        }
        return 0;
    }

    /**
     * Move point to forwarded coordinates.
     *
     * @param xCoordinate Represent x coordinate where to move
     * @param yCoordinate Represent y coordinate where to move.
     */

    @Override
    public void moveTo(int xCoordinate, int yCoordinate) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
    }

    /**
     * Create new instance of this point.
     */
    public Point clone() {
        return new Point(xCoordinate, yCoordinate, getColor());
    }

    /**
     * Calculate distance between two points.
     *
     * @param point Point in relation to which the distance is calculated
     * @return Distance between two points.
     */
    public double distance(Point point) {
        return Math.sqrt(Math.pow(xCoordinate - point.xCoordinate, 2) + Math.pow(yCoordinate - point.yCoordinate, 2));
    }

    public int getXcoordinate() {
        return xCoordinate;
    }

    public void setXcoordinate(int xCoordinate) {
        this.xCoordinate = xCoordinate;
    }

    public int getYcoordinate() {
        return yCoordinate;
    }

    public void setYcoordinate(int yCoordinate) {
        this.yCoordinate = yCoordinate;
    }
}
