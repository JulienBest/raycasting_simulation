package sample;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import sample.model.MouseCircle;
import sample.viewmodel.ObstacleGenerator;

public class Main extends Application {

    static Pane root;
    public static final int RAY_COUNT = 20;

    @Override
    public void start(Stage primaryStage) throws Exception {
        root = new Pane();
        primaryStage.setTitle("Raycasting");
        Scene scene = new Scene(root, 1500, 800, Color.grayRgb(30));
        primaryStage.setScene(scene);
        primaryStage.show();

        ObstacleGenerator generator = new ObstacleGenerator();
        generator.generateObstacles();

        MouseCircle mouse = new MouseCircle();
        root.getChildren().add(mouse);
        mouse.generateRays();

        root.setOnMouseMoved(mouseEvent -> {
            mouse.setTranslateX(mouseEvent.getX());
            mouse.setTranslateY(mouseEvent.getY());
            mouse.updateRays();
        });
    }

    public static Pane getRoot() {
        return root;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
