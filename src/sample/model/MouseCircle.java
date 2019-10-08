package sample.model;

import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import sample.Main;

import java.util.ArrayList;

public class MouseCircle extends Circle {

    ArrayList<Ray> rays;

    public MouseCircle() {
        super(0,0,10, Paint.valueOf("FFFFFF"));
        rays = new ArrayList<>();
    }

    public void generateRays() {
        for (int i = 0; i < Main.RAY_COUNT; i++) {
            double randX = Math.random() * 1500;
            double randY = Math.random() * 800;
            Ray newRay = new Ray(this.getX(), this.getY(), randX, randY);
            rays.add(newRay);
            Main.getRoot().getChildren().add(newRay);
        }
    }

    public void updateRays() {
        for (Ray ray : rays) {
            ray.setStartX(this.getX());
            ray.setStartY(this.getY());
        }
    }

    public double getX() {
        return this.getTranslateX();
    }

    public double getY() {
        return this.getTranslateY();
    }
}
