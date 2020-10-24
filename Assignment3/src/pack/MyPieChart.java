package pack;

import javafx.scene.canvas.GraphicsContext;
import java.util.HashMap;
import java.util.Map;

public class MyPieChart {
    private final double centerX, centerY, RADIUS;
    private final int EVENTS, TOTAL;
    private HashMap<Character,Integer> frequency;
    public MyPieChart(double x, double y, double radius, int events, HashMap<Character,Integer> frequency) {
        centerX = x;
        centerY = y;
        RADIUS = radius;
        EVENTS = events;
        this.frequency = frequency;
        int temp = 0;
        for (int i : frequency.values()) temp += i;
        TOTAL = temp;
    }

    public void draw(GraphicsContext gc){
        double degrees = 0, remainingLetters = TOTAL, shift, max, textX, textY, probability, radius, midAngle;
        MyOval PIE = new MyOval(centerX-RADIUS, centerY-RADIUS, RADIUS*2, RADIUS*2, MyColor.LIGHTGREY.getCol());
        PIE.draw(gc);
        MyArc partition;
        for (int i = 0; i < EVENTS; ++i){
            max = 0; Character c = 'A';
            for (Map.Entry<Character,Integer> k : frequency.entrySet()){
                if (k.getValue() > max){ max = k.getValue(); c = k.getKey(); }
            }
            if (c != 'A') frequency.remove(c);
            probability = max/TOTAL;
            remainingLetters -= max;
            shift = 360 * probability;
            midAngle = degrees + shift/2;
            radius = PIE.getRadius(midAngle);
            partition = new MyArc(degrees,shift,PIE,MyColor.getRandom());
            partition.draw(gc);
            textX = (radius * 11/10) * Math.cos(Math.toRadians(midAngle));
            textY = (radius * 11/10) * Math.sin(Math.toRadians(midAngle));
            if (midAngle > 100 && midAngle < 260){ textX -= radius/6; }
            degrees += shift;
            gc.setFill(MyColor.BLACK.getCol());
            gc.fillText((String.format("%c, %.4f", c, probability)), centerX + textX, centerY - textY);
            if (i+1 == EVENTS){
                midAngle = (360 - degrees)/2;
                radius = PIE.getRadius(midAngle);
                textX = (radius * 11/10) * Math.cos(Math.toRadians(midAngle));
                textY = (radius * 11/10) * Math.sin(Math.toRadians(midAngle));
                if (midAngle > 100 && midAngle < 260){ textX -= radius - radius * Math.abs((180 - midAngle)/180); }
                gc.fillText((String.format("All other letters, %.4f", remainingLetters/TOTAL)), centerX + textX, centerY + textY);
                break;
            }
        }
    }
}
