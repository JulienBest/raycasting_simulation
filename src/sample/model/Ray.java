package sample.model;

import javafx.scene.paint.Paint;
import javafx.scene.shape.Line;

public class Ray extends Line {

    public Ray(double startX, double startY, double endX, double endY) {
        this.setStartX(startX);
        this.setStartY(startY);
        this.setEndX(endX);
        this.setEndY(endY);
        this.setStroke(Paint.valueOf("FFFFFF"));
    }
}
