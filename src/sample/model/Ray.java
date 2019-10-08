package sample.model;

import javafx.geometry.Point2D;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import sample.GlobalVariables;
import sample.Main;
import sample.viewmodel.LinePointCalculator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Ray extends Line {

    ArrayList<Point2D> points;
    LinePointCalculator pointCalculator;


    public Ray(double startX, double startY, double endX, double endY) {
        this.setStartX(startX);
        this.setStartY(startY);
        this.setEndX(endX);
        this.setEndY(endY);
        this.setStroke(Paint.valueOf("FFFFFF"));
        points = new ArrayList<>();

        pointCalculator = new LinePointCalculator();
        paintPoints();
    }

    public void checkObstacles() {
        Map<Point2D, Double> indexDistance = new HashMap<>();

        double distance = Double.MAX_VALUE;
        double distanceToStart = Double.MAX_VALUE;
        for (Obstacle obstacle : Main.getGenerator().getObstacles()) {
            for (Border border : obstacle.getBorders()) {
                for (Point2D borderPoint : border.getPoints()) {
                    for (Point2D rayPoint : this.points) {
                        distance = Math.abs(borderPoint.getX() - rayPoint.getX()) + Math.abs(borderPoint.getY() - rayPoint.getY());
                        if (distance < GlobalVariables.INTERSECT_DISTANCE) {
                            distanceToStart = Math.abs(borderPoint.getX() - getStartX()) + Math.abs(borderPoint.getY() - getStartY());
                            indexDistance.put(borderPoint, distanceToStart);
                        }
                    }
                }
            }
        }

        if (!indexDistance.isEmpty()) {
            Point2D minDistancePoint = new Point2D(0, 0);
            double minDistance = Double.MAX_VALUE;
            Iterator it = indexDistance.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry pair = (Map.Entry) it.next();
                if ((double) pair.getValue() < minDistance) {
                    minDistance = (double) pair.getValue();
                    minDistancePoint = (Point2D) pair.getKey();
                }
                it.remove();
            }
            if (minDistancePoint.getX() + minDistancePoint.getY() > 0) {
                this.setEndX(minDistancePoint.getX());
                this.setEndY(minDistancePoint.getY());
            }
        }

    }

    public void calulatePoints() {
        this.points = pointCalculator.getPoints(this);
    }

    public void paintPoints() {
        for (Point2D point : points) {
            Main.getRoot().getChildren().add(new Circle(point.getX(), point.getY(), 1, Paint.valueOf("Red")));
        }
    }
}
