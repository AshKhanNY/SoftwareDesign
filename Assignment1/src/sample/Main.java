/* Ashraq Khan // CS 22100 Assignment 1 // 09/21/2020 */

package sample;

/* Imports */
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/* Driver class */
public class Main extends Application {
    // Sets boundaries of stage
    final int WIDTH = 1000;
    final int HEIGHT = 600;

    @Override
    public void start(Stage primaryStage) {
        try {
            // Sets up primary stage, canvas, and graphics context
            primaryStage.setTitle("Assignment 1");
            Canvas canvas = new Canvas(WIDTH, HEIGHT);
            GraphicsContext gc = canvas.getGraphicsContext2D();
            gc.setLineWidth(3);

            // Prints alternate hexagons and circles of different colors
            MyPolygon hexGray = new MyPolygon(WIDTH/2,HEIGHT/2, 200,6,MyColor.GREY.getCol());
            hexGray.draw(gc);
            MyCircle circleY = new MyCircle(WIDTH/2,HEIGHT/2, hexGray.getApothem(), MyColor.YELLOW.getCol());
            circleY.draw(gc);
            MyPolygon hexGreen = new MyPolygon(WIDTH/2,HEIGHT/2, circleY.getRadius(), 6,MyColor.LIME.getCol());
            hexGreen.draw(gc);
            MyCircle circleP = new MyCircle(WIDTH/2,HEIGHT/2, hexGreen.getApothem(), MyColor.HOTPINK.getCol());
            circleP.draw(gc);
            MyPolygon hexBlue = new MyPolygon(WIDTH/2,HEIGHT/2, circleP.getRadius(),6,MyColor.CYAN.getCol());
            hexBlue.draw(gc);
            hexGray.border(gc);

            // Lists properties of all shapes
            System.out.println(hexGray + "\n\n" + circleY + "\n\n" + hexGreen + "\n\n" + circleP + "\n\n" + hexBlue + "\n\n");

            MyLine line1 = new MyLine(0,WIDTH,0,HEIGHT,MyColor.BLACK.getCol());
            MyLine line2 = new MyLine(0,WIDTH,HEIGHT,0,MyColor.BLACK.getCol());
            line1.draw(gc);
            line2.draw(gc);
            gc.strokeRect(0, 0, WIDTH, HEIGHT);

            // Lists properties of all lines
            System.out.println(line1 + "\n\n" + line2 + "\n\n");

            // Sets stack pane and scene for image to appear on
            StackPane root = new StackPane(canvas);
            Scene scene = new Scene(root,WIDTH,HEIGHT);
            primaryStage.setScene(scene);
            primaryStage.show();


        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}