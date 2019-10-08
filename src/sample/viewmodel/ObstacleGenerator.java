package sample.viewmodel;

import sample.Main;
import sample.model.Obstacle;

public class ObstacleGenerator {

    public void generateObstacles() {
        Main.getRoot().getChildren().addAll(
                new Obstacle(200,100, 100, 100, 150),
                new Obstacle(250,100, 500, 600, 50),
                new Obstacle(450,100, 1000, 200, 400),
                new Obstacle(200,100, 1200, 650, 150)
                );
    }
}
