/* ----------------------------------------------------------
Class MyPolygon inherits class MyShape. The MyPolygon object
is a regular polygon defined by the integer parameter, N—
the number of the polygon’s equal side lengths and equal
interior angles, and the center (x, y) and radius, r, of the
circle in which it is inscribed. The MyPolygon object may
be filled with a color.
---------------------------------------------------------- */
package sample;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class MyPolygon extends MyShape {
    private double radius;
    private int sides;
    double xp[];
    double yp[];

    MyPolygon(int x, int y, double radius, int sides, Color color){
        super(x,y,color);
        this.radius = radius;
        this.sides = sides;
        xp = new double[sides];
        yp = new double[sides];
        double ang = (2 * Math.PI)/sides;
        for (int i = 0; i < sides; ++i){
            xp[i] = x + (radius*(-1 * Math.sin(i*ang)));
            yp[i] = y + (radius*(-1 * Math.cos(i*ang)));
        }
    }

    public double getRadius(){ return radius; }
    public double getArea(){
        return Math.pow(radius,2) * sides * Math.sin(getAngle()) * 0.5;
    }
    public double getPerimeter(){ return sides * getSide(); }
    public double getApothem(){ return radius * Math.cos(Math.toRadians(180 / sides)); }
    public double getAngle(){ return Math.PI/sides; }
    public double getSide(){ return 2 * radius * Math.sin(Math.PI/sides); }

    @Override
    public String toString(){
        return String.format("----- Polygon Properties -----\n%15s %f\n%15s %f\n%15s %f\n%15s %f\n%15s %f\n%15s "+super.getColor(),
                "Radius:",getRadius(),"Area:",getArea(),"Perimeter:",getPerimeter(),
                "Angle:",getAngle(),"Apothem:",getApothem(),"Color:");
    }

    @Override
    public void draw(GraphicsContext gc){
        gc.setFill(super.getColor());
        gc.setStroke(super.getColor());
        gc.setLineWidth(3);
        gc.strokePolygon(xp, yp, sides);
        gc.fillPolygon(xp, yp, sides);
    }

    public void border(GraphicsContext gc){
        gc.setStroke(Color.BLACK);
        for (int i = 1; i < sides; ++i){
            gc.strokeLine(xp[i-1], yp[i-1], xp[i], yp[i]);
        }
        gc.strokeLine(xp[sides-1], yp[sides-1], xp[0], yp[0]);
    }
}