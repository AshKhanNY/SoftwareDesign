/* ----------------------------------------------------------
Class MyShape is the hierarchy’s superclass and inherits the
Java class Object. An implementation of the class defines a
reference point (x, y) and the color of the shape.
---------------------------------------------------------- */
package pack;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import java.util.ArrayList;
import java.util.HashSet;

// implements MyShapeInterface
public abstract class MyShape implements MyShapeInterface {
    private MyPoint point; // Point of shape in pixels
    private Color color;

    MyShape(double x, double y, Color color){
        this.point = new MyPoint(x,y);
        this.color = color;
    }

    public double getX(){ return point.getX(); }
    public double getY(){ return point.getY(); }
    public Color getColor(){ return color; }
    public void setX(int x){ this.point.setX(x); }
    public void setY(int y){ this.point.setY(y); }
    public void setColor(Color color){ this.color = color; }

    @Override
    public ArrayList<MyPoint> overlapMyShapes(MyShape shape) {
        ArrayList<MyPoint> overlap = new ArrayList<>();
        HashSet<String> pointStr = new HashSet<>();
        for (MyPoint point : shape.getMyArea()){
            pointStr.add(point.toString());
        }
        for (MyPoint point : this.getMyArea()){
            if (pointStr.contains(point.toString())){
                overlap.add(point);
            }
        }
        return overlap;
    }

    public abstract String toString();
    public abstract void draw(GraphicsContext gc);
}