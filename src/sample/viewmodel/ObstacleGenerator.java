package sample.viewmodel;

import sample.Main;
import sample.model.Obstacle;

import java.util.ArrayList;

public class ObstacleGenerator {

    private ArrayList<Obstacle> obstacles;

    public ObstacleGenerator() {
        this.obstacles = new ArrayList<>();
    }

    public void generateObstacles() {
        obstacles.add(new Obstacle(200, 100, 100, 100, 150));
        obstacles.add(new Obstacle(250, 100, 500, 600, 50));
        obstacles.add(new Obstacle(450, 100, 1000, 200, 400));
        obstacles.add(new Obstacle(200, 100, 1200, 650, 150));

        for (Obstacle obstacle : obstacles) {
            Main.getRoot().getChildren().add(obstacle);
        }
    }

    public ArrayList<Obstacle> getObstacles() {
        return obstacles;
    }
}
