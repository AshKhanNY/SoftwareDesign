/* ----------------------------------------------------------
Class MyLine inherits class MyShape. The MyLine object is a
straight line defined by the endpoints (x1, y1) and (x2, y2).
The MyLine object may be of any color.
---------------------------------------------------------- */
package pack;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import java.util.ArrayList;

public class MyLine extends MyShape {
    private final double x1, y1, x2, y2; // Coordinates of two points of line

    MyLine(double x1, double y1, double x2, double y2, Color color){
        super(0, 0, color);
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    public double getLength(){ return Math.sqrt(Math.pow(x2-x1,2) + Math.pow(y2-y1,2)); }
    public static double getLength(double x1, double y1, double x2, double y2){ return Math.sqrt(Math.pow(x2-x1,2) + Math.pow(y2-y1,2)); }
    public double get_xAngle() {
        double angle = Math.toDegrees(Math.atan2(y2 - y1, x2 - x1));
        if(angle < 0){
            angle += 360;
        }
        return angle;
    }

    @Override
    public String toString(){
        return String.format("----- Line Properties -----\n%15s (%.2f,%.2f)\n%15s (%.2f,%.2f)\n%15s %.2f\n%15s %.2f\n%15s "+super.getColor(),
                "Point 1:",x1,y1,"Point 2:",x2,y2,"Line Length:",getLength(),"Angle:",get_xAngle(),"Color:");
    }
    @Override
    public MyRectangle getMyBoundingRectangle(){
        double cornerX, cornerY;
        cornerX = Math.min(x1, x2);
        cornerY = Math.min(y1, y2);
        return new MyRectangle(cornerX, cornerY, Math.abs(x2-x1), Math.abs(y2-y1), super.getColor());
    }

    @Override
    public ArrayList<MyPoint> getMyArea() {
        ArrayList<MyPoint> set = new ArrayList<>();
        double m = (y2 - y1) / (x2 - x1), intersect = y1 - (m * x1);
        MyRectangle bound = getMyBoundingRectangle();
        double len = getLength(), bX = bound.getX(), bY = bound.getY();

        for (double x = bX; x <= bX + bound.getWidth(); ++x)
            for (double y = bY; y <= bY + bound.getHeight(); ++y)
                if (Math.abs(y - (m * x + intersect)) < 1)
                    set.add(new MyPoint(x, y));
        if (Math.abs(get_xAngle() - 90) < 1) { for (int i = 0; i < len; ++i) set.add(new MyPoint(x1, y1 + i)); }
        else if (Math.abs(get_xAngle() - 270) < 1) { for (int i = 0; i < len; ++i) set.add(new MyPoint(x1, y1 - i)); }
        return set;
    }

    @Override
    public void draw(GraphicsContext gc){
        gc.setStroke(super.getColor());
        gc.strokeLine(x1,y1,x2,y2);
    }
}