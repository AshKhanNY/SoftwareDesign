/* ----------------------------------------------------------
Class MyCircle inherits class MyShape.  The MyCircle object
is defined by its center (x, y) and radius r, and may be
filled with a color.
---------------------------------------------------------- */
package sample;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class MyCircle extends MyShape {
    private double radius;

    MyCircle(int x, int y, double radius, Color color){
        super(x,y,color);
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
        return String.format("----- Circle Properties -----\n%15s %f\n%15s %f\n%15s %f\n%15s "+super.getColor(),
                "Radius:",getRadius(),"Area:",getArea(),"Perimeter:",getPerimeter(),"Color:");
    }
    @Override
    public void draw(GraphicsContext gc){
        gc.setFill(super.getColor());
        gc.fillOval(super.getX() - radius, super.getY() - radius, 2 * radius, 2 * radius);
        //gc.strokeRect(super.getX() - radius, super.getY() - radius, 2 * radius, 2 * radius);
    }
}