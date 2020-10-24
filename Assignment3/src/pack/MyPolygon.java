/* ----------------------------------------------------------
Class MyPolygon inherits class MyShape. The MyPolygon object
is a regular polygon defined by the integer parameter, N—
the number of the polygon’s equal side lengths and equal
interior angles, and the center (x, y) and radius, r, of the
circle in which it is inscribed. The MyPolygon object may
be filled with a color.
---------------------------------------------------------- */
package pack;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import java.util.ArrayList;

public class MyPolygon extends MyShape {
    private double radius;
    private int sides;
    // Arrays for holding points of each corner on polygon
    double xp[];
    double yp[];

    MyPolygon(double x, double y, double radius, int sides, Color color){
        // (x,y) is the center point
        super(x,y,color);
        this.radius = radius;
        this.sides = sides;
        xp = new double[sides];
        yp = new double[sides];
        // Finds correct position of corner points on regular polygon
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
    public double getDistance(double angle){
        angle = Math.toRadians(angle);
        double x = radius * Math.cos(angle) + super.getX();
        double y = radius * Math.sin(angle) + super.getY();
        return Math.sqrt(Math.pow(x - super.getX(), 2) + Math.pow(y - super.getY(), 2));
    }
    public double getAngle(){ return Math.PI/sides; }
    public double getSide(){ return 2 * radius * Math.sin(Math.PI/sides); }

    @Override
    public String toString(){
        return String.format("----- Polygon Properties -----\n%15s %.2f\n%15s %.2f\n%15s %.2f\n%15s %.2f\n%15s %.2f\n%15s "+super.getColor(),
                "Radius:",getRadius(),"Area:",getArea(),"Perimeter:",getPerimeter(),
                "Angle:",getAngle(),"Apothem:",getApothem(),"Color:");
    }
    @Override
    public MyRectangle getMyBoundingRectangle(){
        return new MyRectangle((super.getX() - radius), (super.getY() - radius),
                2*radius, 2*radius, super.getColor());
    }

    @Override
    public ArrayList<MyPoint> getMyArea() {
        final Color color = super.getColor();
        // ArrayList for holding set of all points in area
        ArrayList<MyPoint> set = new ArrayList<>();
        // ArrayList for holding all lines from origin to each point on polygon sides
        ArrayList<MyLine> radialLines = new ArrayList<>();
        // ArrayList for holding all sides
        ArrayList<MyLine> sideLines = new ArrayList<>();
        for (int i = 1; i < sides; ++i){
            sideLines.add(new MyLine(xp[i-1], yp[i-1], xp[i], yp[i], color));
        } sideLines.add(new MyLine(xp[sides-1], yp[sides-1], xp[0], yp[0], color));
        // Draws line from origin to each point on the sides. The summation of the areas of each line will be the
        // area of the polygon.
        for (int i = 0; i < sides; ++i){
            for (MyPoint point : sideLines.get(i).getMyArea()){
                radialLines.add(new MyLine(super.getX(), super.getY(), point.getX(), point.getY(), color));
            }
        }
        // Adds area of all lines into set as an approximation for area of polygon.
        for (MyLine radialLine : radialLines) {
            set.addAll(radialLine.getMyArea());
        }
        return set;
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