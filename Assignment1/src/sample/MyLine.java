/* ----------------------------------------------------------
Class MyLine inherits class MyShape. The MyLine object is a
straight line defined by the endpoints (x1, y1) and (x2, y2).
The MyLine object may be of any color.
---------------------------------------------------------- */
package sample;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class MyLine extends MyShape {
    private int x1, y1, x2, y2; // Coordinates of two points of line

    MyLine(int x1, int x2, int y1, int y2, Color color){
        super(0, 0, color);
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
    }

    public double getLength(){
        return Math.sqrt(Math.pow(x2-x1,2) + Math.pow(y2-y1,2));
    }
    public double get_xAngle(){
        return Math.toDegrees(Math.atan((y2-y1)/(x2-x1)));
    }

    @Override
    public String toString(){
        return String.format("----- Line Properties -----\n%15s (%d,%d)\n%15s (%d,%d)\n%15s %f\n%15s %f\n%15s "+super.getColor(),
                "Point 1:",x1,y1,"Point 2:",x2,y2,"Line Length:",getLength(),"Angle:",get_xAngle(),"Color:");
    }
    @Override
    public void draw(GraphicsContext gc){
        gc.setStroke(super.getColor());
        gc.strokeLine(x1,y1,x2,y2);
    }
}