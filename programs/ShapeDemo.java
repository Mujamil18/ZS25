package special.programs;

public class ShapeDemo {
    public static void main(String[] args) {
        Shape s = new Circle("circle", 5);
        s.calculateArea();
        System.out.println(s.getArea());

        Circle c = new Circle("circle", 2);
        c.calculateArea();
        System.out.println(c.getArea());

        double rad = c.getRadius();
        c = new Sphere("sphere", rad);
        c.calculateArea();
        System.out.println(c.getArea());


    }
}
class Shape{
    String name;
    double area;
    public Shape(){}
    public Shape(String name){
        this.name = name;
    }
    public void calculateArea(){
        System.out.println("Calculation area of "+ this.name);
    }
    public double getArea(){
        return area;
    }

}
class Circle extends Shape{
    private String name;
    double radius;
    private double area;
    private double volume;

    public Circle(){}
    public Circle(double radius){
        this.radius = radius;
    }

    public Circle(String name, double radius){
        super(name);
        this.radius = radius;
    }
    public Circle(String name, double radius, double area){
        super(name);
        this.radius = radius;
        this.area = area;
    }
    @Override
    public void calculateArea(){
        this.area = 3.14 * this.radius * this.radius;
    }
    public double getArea(){
        return area;
    }
    public double getRadius(){
        return radius;
    }
}
class Sphere extends Circle{
    private String name;
    private double radius;
    private double area;

    public Sphere(String name,double radius){
        this.name = name;
        this.radius=super.radius;
    }
    @Override
    public void calculateArea(){
        this.area = super.getArea() * this.radius;
    }
    public double getRadius(){
        return radius;
    }
    public double getArea(){
        return area;
    }

}
