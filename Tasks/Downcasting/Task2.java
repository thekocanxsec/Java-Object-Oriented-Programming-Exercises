package Downcasting;

import java.util.ArrayList;
import java.util.List;

public class Task2 {
}

interface Drawable{
    void draw();
}

abstract class Shape implements Drawable{

}

class Circle extends Shape{
    private double radius;

    public Circle(double radius){
        this.radius = radius;
    }

    public void setRadius(double radius){
        this.radius = radius;
    }

    public double getRadius(){
        return this.radius;
    }

    @Override
    public void draw(){
        System.out.println("Drawing Circle!");
    }

}

class Square extends Shape{
    private double sidelength;

    public Square(double sidelength){
        this.sidelength = sidelength;
    }

    public void setSidelength(double sidelength){
        this.sidelength = sidelength;
    }

    public double getSidelength(){
        return this.sidelength;
    }

    @Override
    public void draw(){
        System.out.println("Drawing Square");
    }
}

class ShapeManager{
    public List<Drawable> drawAll(List<Drawable> shapes){
        for(Drawable shape : shapes){
            if(shape instanceof Circle){
                Circle circle = (Circle) shape;
                circle.setRadius(15);
            }
            else if(shape instanceof Square){
                Square square = (Square) shape;
                square.setSidelength(5);
            }
        }
        return shapes;
    }
}

class MainRun2{
    static void main(String[] args) {
        List<Drawable> drawables = new ArrayList<>();
        Circle c = new Circle(4.0);
        Square s = new Square(2.0);

        drawables.add(c);
        drawables.add(s);

        ShapeManager shapeManager = new ShapeManager();
        shapeManager.drawAll(drawables);

        System.out.println("Circle radius after downcast and update: " + c.getRadius());
        System.out.println("Square sidelength after downcast and update: " + s.getSidelength());
    }
}