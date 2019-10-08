package sample.model;

import javafx.geometry.Point2D;
import javafx.scene.shape.Line;
import sample.viewmodel.LinePointCalculator;

import java.util.ArrayList;

public class Border extends Line {

    private ArrayList<Point2D> points;
    private LinePointCalculator pointCalculator;


    public Border(double v, double v1, double v2, double v3) {
        super(v, v1, v2, v3);
        points = new ArrayList<>();
        pointCalculator = new LinePointCalculator();
        calulatePoints();
    }

    public void calulatePoints() {
        this.points = pointCalculator.getPoints(this);
    }

    public ArrayList<Point2D> getPoints() {
        return points;
    }
}
