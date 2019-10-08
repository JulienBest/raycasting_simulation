package sample.model;

import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

import java.util.ArrayList;

public class MouseCircle extends Circle {

    ArrayList<Ray> rays;

    public MouseCircle() {
        super(0,0,10, Paint.valueOf("FFFFFF"));
        rays = new ArrayList<>();
    }
}
