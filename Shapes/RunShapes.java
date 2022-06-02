/*
Josh Knopf
February 17, 2022
Shapes
Demonstrates inheritance type classes to produce different output depending on the shape.
*/
public class RunShapes { //Runs the classes
   public static void main(String[] args) {
         
      Rectangle re = new Rectangle("shape", "rectangle");
      System.out.println(re.toString());
      
      Triangle tr = new Triangle("shape", "triangle");
      System.out.println(tr.toString());
      
      Circle ci = new Circle("shape", "circle");
      System.out.println(ci.toString());
      //new Rectangle();
      //new Triangle();
      //new Circle();
   }  
}

class Shapes { //The parent class that contains a commonly used method
   public String shape;
   public Shapes(String shape) {
      this.shape = shape;
   }
   public String toString() {
      return ("I am a shape! Shapes are cool!\n" + repeatShape());
   }
   public String repeatShape() {
      String x = "";
      for (int i = 0; i < 5; i++) {
         x += "Shape\n";
      }
      return x;
   }
}

class Rectangle extends Shapes { //A class that inherites the Shapes class and adds to it
   public String rectangle;
   public Rectangle(String shape, String startRectangle) {
      super(shape);
      rectangle = startRectangle;   
   }
   @Override public String toString() {
      return ("\nI am a rectangle... who has 4 sides \n" + super.toString());
   }
}

class Triangle extends Shapes { //A class that inherites the Shapes class and adds to it
   public String triangle;
   public Triangle(String shape, String startTriangle) {
      super(shape);
      triangle = startTriangle;
   }
   @Override public String toString() {
      return ("I am a triangle\n" + repeatSide() + super.toString());
   }
   public String repeatSide() {
      String x = "";
      for (int i = 0; i < 3; i++) {
         x += "I have 3 sides\n";
      }
      return x;
   }
}

class Circle extends Shapes { //A class that inherites the Shapes class and adds to it
   public String circle;
   public Circle(String shape, String startCircle) {
      super(shape);
      circle = startCircle;
   }
   @Override public String toString() {
      return ("I am round" + repeatRoll() + super.toString());
   }
   public String repeatRoll() {
      String x = "";
      for (int i = 0; i < 7; i++) {
         x += "I like to roll!\n";
      }
      return x;
   }
}