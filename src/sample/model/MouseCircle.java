package sample.model;

import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import sample.GlobalVariables;
import sample.Main;

import java.util.ArrayList;

public class MouseCircle extends Circle {

    ArrayList<Ray> rays;
    private final int RADIUS = 2000;

    public MouseCircle() {
        super(0,0,10, Paint.valueOf("FFFFFF"));
        rays = new ArrayList<>();
    }

    public void generateRays() {
        for (int i = 0; i < GlobalVariables.RAY_COUNT; i++) {
            double randX = Math.random() * 1500;
            double randY = Math.random() * 800;
            Ray newRay = new Ray(this.getX(), this.getY(), randX, randY);
            rays.add(newRay);
            Main.getRoot().getChildren().add(newRay);
        }
    }

    public void updateRays() {
        double increments = 360 / GlobalVariables.RAY_COUNT;
        double t = 0;
        for (Ray ray : rays) {
            double x = RADIUS * Math.cos(t) + this.getX();
            double y = RADIUS * Math.sin(t) + this.getY();
            ray.setStartX(this.getX());
            ray.setStartY(this.getY());
            ray.setEndX(x);
            ray.setEndY(y);
            t += increments;

            ray.calulatePoints();
            ray.checkObstacles();
        }
    }

    public double getX() {
        return this.getTranslateX();
    }

    public double getY() {
        return this.getTranslateY();
    }
}
