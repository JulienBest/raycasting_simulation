package sample.model;

import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

public class Obstacle extends Rectangle {

    public Obstacle(int width, int height, int x, int y, double rotation) {
        this.setHeight(height);
        this.setWidth(width);
        this.setTranslateX(x);
        this.setTranslateY(y);
        this.setRotate(rotation);
        //this.setFill(Paint.valueOf("FFFFFF"));
    }
}
