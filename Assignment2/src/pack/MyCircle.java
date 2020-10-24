/* ----------------------------------------------------------
Class MyCircle inherits class MyShape. The MyCircle object
is defined by its center (x, y) and radius r, and may be
filled with a color.
---------------------------------------------------------- */
package pack;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import java.util.ArrayList;

public class MyCircle extends MyOval {
    private double radius;

    MyCircle(double x, double y, double radius, Color color){
        super(x,y,radius*2,radius*2, color);
        this.radius = radius;
    }

    public double getArea(){
        return Math.PI * Math.pow(radius, 2);
    }
    public double getPerimeter(){
        return 2 * Math.PI * radius;
    }
    public double getRadius(){ return radius; }

    @Override
    public String toString(){
        return String.format("----- Circle Properties -----\n%15s (%.2f,%.2f)\n%15s %.2f\n%15s %.2f\n%15s %.2f\n%15s "+super.getColor(),
                "Center:",super.getX(),super.getY(),"Radius:",getRadius(),"Area:",getArea(),"Perimeter:",getPerimeter(),"Color:");
    }
    @Override
    public MyRectangle getMyBoundingRectangle(){
        return new MyRectangle((int)(super.getX() - radius), (int)(super.getY() - radius),
                2*radius, 2*radius, super.getColor());
    }

    @Override
    public ArrayList<MyPoint> getMyArea() {
        ArrayList<MyPoint> set = new ArrayList<>();
        // Uses circle equation to determine if point is in region, adds point to set if true
        for (double x = (getX() - radius); x <= radius * 2 + getX(); x++) {
            for (double y = (getY() - radius); y <= radius * 2 + getY(); y++) {
                double dx = x - getX();
                double dy = y - getY();
                double distanceSquared = Math.pow(dx, 2) + Math.pow(dy, 2);
                if (distanceSquared <= Math.pow(radius, 2)) set.add(new MyPoint(x, y));
            }
        }
        return set;
    }

    @Override
    public void draw(GraphicsContext gc){
        gc.setFill(super.getColor());
        gc.setStroke(super.getColor());
        gc.strokeOval(super.getX() - radius, super.getY() - radius, 2 * radius, 2 * radius);
        gc.fillOval(super.getX() - radius, super.getY() - radius, 2 * radius, 2 * radius);
    }
}