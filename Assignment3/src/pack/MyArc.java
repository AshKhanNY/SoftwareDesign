package pack;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import java.util.ArrayList;

public class MyArc extends MyShape {
    private final MyOval BASE;
    private double startAngle;
    private final double SHIFT;

    // Start point is from super, which is (x1,y1), end point is (x2,y2)
    // startAngle and shift are in degrees
    public MyArc(double ang1, double shift, MyOval base, Color color) {
        super(base.getCenter().getX(), base.getCenter().getY(), color);
        SHIFT = shift;
        BASE = base;
        startAngle = ang1;
        // Keeps angle between 0 and 360, inclusive
        while (startAngle < 0) startAngle += 360;
    }

    @Override
    public MyRectangle getMyBoundingRectangle() {
        return null;
    }

    @Override
    public ArrayList<MyPoint> getMyArea() {
        return null;
    }

    @Override
    public String toString() {
        return String.format("----- Arc Properties -----\n%15s (%.2f,%.2f)\n%15s %.2f\n%15s %.2f\n%15s "+super.getColor(),
                "Center:",BASE.getCenter().getX() - BASE.getWidth()/2,
                BASE.getCenter().getY() - BASE.getHeight()/2,
                "Start Angle:",startAngle,"End Angle:",startAngle + SHIFT,"Color:");
    }

    @Override
    public void draw(GraphicsContext gc) {
        final double centerX = BASE.getCenter().getX() - BASE.getWidth()/2;
        final double centerY = BASE.getCenter().getY() - BASE.getHeight()/2;
        gc.setFill(super.getColor());
        gc.setStroke(super.getColor());
        gc.strokeArc(centerX, centerY, BASE.getWidth(),BASE.getHeight(),startAngle,SHIFT,ArcType.ROUND);
        gc.fillArc(centerX, centerY, BASE.getWidth(),BASE.getHeight(),startAngle,SHIFT,ArcType.ROUND);
    }
}
