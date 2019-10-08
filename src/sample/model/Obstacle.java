package sample.model;

import javafx.geometry.Point2D;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import sample.Main;

import java.util.ArrayList;

public class Obstacle extends Rectangle {

    private ArrayList<Border> borders;

    public Obstacle(int width, int height, int x, int y, double rotation) {
        this.setHeight(height);
        this.setWidth(width);
        this.setTranslateX(x);
        this.setTranslateY(y);
        borders = new ArrayList<>();
        //this.setRotate(rotation);
        //this.setFill(Paint.valueOf("FFFFFF"));
        calculateBorders();
    }

    private Point2D getLeftUpperCorner() {
        return new Point2D(this.getTranslateX(), this.getTranslateY());
    }

    private Point2D getRightUpperCorner() {
        return new Point2D(this.getTranslateX() + this.getWidth(), this.getTranslateY());
    }

    private Point2D getLeftBottomCorner() {
        return new Point2D(this.getTranslateX(), this.getTranslateY() + this.getHeight());
    }

    private Point2D getRightBottomCorner() {
        return new Point2D(this.getTranslateX() + this.getWidth(), this.getTranslateY() + this.getHeight());
    }

    private void calculateBorders() {
        borders.add(new Border(getLeftUpperCorner().getX(), getLeftUpperCorner().getY(), getLeftBottomCorner().getX(), getLeftBottomCorner().getY()));
        borders.add(new Border(getRightUpperCorner().getX(), getRightUpperCorner().getY(), getRightBottomCorner().getX(), getRightBottomCorner().getY()));
        borders.add(new Border(getLeftUpperCorner().getX(), getLeftUpperCorner().getY(), getRightUpperCorner().getX(), getRightUpperCorner().getY()));
        borders.add(new Border(getLeftBottomCorner().getX(), getLeftBottomCorner().getY(), getRightBottomCorner().getX(), getRightBottomCorner().getY()));

        //drawBorders();
    }

    public ArrayList<Border> getBorders() {
        return borders;
    }

    public void drawBorders() {
        for (Line line : borders) {
            Main.getRoot().getChildren().add(line);
        }
    }
}
