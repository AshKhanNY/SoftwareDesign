/* Ashraq Khan // CS 22100 Assignment 2 // 10/10/2020 */
package pack;

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
            primaryStage.setTitle("Assignment 2");
            Canvas canvas = new Canvas(WIDTH, HEIGHT);
            GraphicsContext gc = canvas.getGraphicsContext2D();

            // Draws alternate ovals and rectangles of random colors
            double width = 500, height = 300, centerX = WIDTH/2, centerY = HEIGHT/2;
            MyOval oval; MyRectangle rect;
            rect = new MyRectangle(centerX - width/2, centerY - height/2, width, height, MyColor.getRandom());
            rect.draw(gc);
            System.out.println(rect + "\n\n");
            for (int i = 1; i < 6; ++i){
                if (i % 2 != 0) {
                    oval = new MyOval(centerX - width/2, centerY - height/2, width, height, MyColor.getRandom());
                    oval.draw(gc);
                    System.out.println(oval + "\n\n");
                } else {
                    width /= Math.sqrt(2);
                    height /= Math.sqrt(2);
                    rect = new MyRectangle(centerX - width/2, centerY - height/2, width, height, MyColor.getRandom());
                    rect.draw(gc);
                    System.out.println(rect + "\n\n");
                }
            }

            // Finishing off with desired horizontal line and slightly thick window border
            MyLine line1 = new MyLine(0,0,WIDTH,HEIGHT,MyColor.BLACK.getCol());
            line1.draw(gc);
            System.out.println(line1 + "\n\n");
            gc.setLineWidth(5);
            gc.strokeRect(0, 0, WIDTH, HEIGHT);

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