/* ----------------------------------------------------------
Class MyShape is the hierarchy’s superclass and inherits the
Java class Object. An implementation of the class defines a
reference point (x, y) and the color of the shape.
---------------------------------------------------------- */
package sample;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class MyShape {
    private int x, y; // Point of shape in pixels
    private Color color;

    MyShape(int x, int y, Color color){
        this.x = x;
        this.y = y;
        this.color = color;
    }

    public int getX(){ return x; }
    public int getY(){ return y; }
    public Color getColor(){ return color; }
    public void setX(int x){ this.x = x; }
    public void setY(int y){ this.y = y; }
    public void setColor(Color color){ this.color = color; }

    public String toString(){
        return String.format("----- Shape Properties -----\n%15s (%d,%d)\n%15s " + getColor(),
                "Start Point:",x,y,"Color:");
    }
    public void draw(GraphicsContext gc){
        gc.setFill(color);
        gc.fill();
    }
}