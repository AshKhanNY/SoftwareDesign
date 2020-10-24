/* ----------------------------------------------------------
Class MyPoint is used by class MyShape to define the
reference point p(x, y) of the Java display coordinate
system.
---------------------------------------------------------- */
package pack;

import javafx.scene.canvas.GraphicsContext;

public class MyPoint {
    private double x;
    private double y;

    public MyPoint(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() { return x; }
    public double getY() { return y; }
    public void setX(double x) { this.x = x; }
    public void setY(double y) { this.y = y; }

    @Override
    public String toString() {
        return String.format("----- Point Properties -----\n%15s (%.2f,%.2f)","Point:",x,y);
    }

    public void draw(GraphicsContext gc){
        gc.setFill(MyColor.BLACK.getCol());
        gc.fillOval(x, y, 1, 1);
    }
}
