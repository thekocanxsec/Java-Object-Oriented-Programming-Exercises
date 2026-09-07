import java.util.ArrayList;
import java.util.List;

class Task6 {
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
        System.out.println("Drawing Circle");
    }
}

class Square extends Shape{
    private double sideLength;

    public Square(double sideLength){
        this.sideLength = sideLength;
    }

    public void setSideLength(double sideLength){
        this.sideLength = sideLength;
    }

    public double getSideLength(){
        return this.sideLength;
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
                square.setSideLength(5);
            }
        }
        return shapes;
    }
}



class MainRun6 {
    public static void main(String[] args) {
        List<Drawable> shapes = new ArrayList<>();

        Circle circle = new Circle(5.0);
        Square square = new Square(10.0);

        shapes.add(circle);
        shapes.add(square);

        System.out.println("--- Before ShapeManager Update ---");
        System.out.println("Circle radius: " + circle.getRadius());
        System.out.println("Square side length: " + square.getSideLength());

        ShapeManager manager = new ShapeManager();
        List<Drawable> processedShapes = manager.drawAll(shapes);

        System.out.println("\n--- After ShapeManager Update (Circle radius -> 15, Square side -> 5) ---");
        System.out.println("Circle radius: " + circle.getRadius()); // Expected: 15.0
        System.out.println("Square side length: " + square.getSideLength()); // Expected: 5.0
    }
}

