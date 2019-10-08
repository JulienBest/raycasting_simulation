package sample.viewmodel;

import javafx.geometry.Point2D;
import javafx.scene.shape.Line;
import sample.GlobalVariables;
import sample.Main;

import java.util.ArrayList;

public class LinePointCalculator {


    public ArrayList<Point2D> getPoints(Line line) {
        ArrayList<Point2D> points = new ArrayList<>();
        for (Point2D point : points) {
            Main.getRoot().getChildren().remove(point);
        }
        points.clear();
        double ratioX = (line.getEndX() - line.getStartX()) / GlobalVariables.POINTS_COUNT;
        double ratioY = (line.getEndY() - line.getStartY()) / GlobalVariables.POINTS_COUNT;
        double x = line.getStartX();
        double y = line.getStartY();

        for (int i = 0; i < GlobalVariables.POINTS_COUNT; i++) {
            x += ratioX;
            y += ratioY;
            points.add(new Point2D(x, y));
        }
        return points;
    }
}
