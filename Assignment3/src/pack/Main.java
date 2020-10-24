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
    final int WIDTH = 1700;
    final int HEIGHT = 900;

    @Override
    public void start(Stage primaryStage) {
        try {
            // Sets up primary stage, canvas, and graphics context
            primaryStage.setTitle("Assignment 3");
            Canvas canvas = new Canvas(WIDTH, HEIGHT);
            GraphicsContext gc = canvas.getGraphicsContext2D();

            // Obtains hashMap of frequency of letters, and draws a circular pie chart that displays each frequency
            double centerX = WIDTH/2, centerY = HEIGHT/2;
            HistogramAlphaBet emmaText = new HistogramAlphaBet("C:\\Users\\smash\\Documents\\CCNY Fall 2020\\CSC 221\\Assignment3\\Emma.txt");
            MyPieChart textLetters = new MyPieChart(centerX, centerY, HEIGHT/3,10, emmaText.frequencyOfLetters());
            textLetters.draw(gc);

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