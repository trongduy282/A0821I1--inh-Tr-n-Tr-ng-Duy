package _5_access_modifier_static_java.exercise;

public class Circle {
    private double radius =1.0;
    private String color ="red";
    Circle(){};
    Circle(double r){
        this.radius =r;
    }
    public double getRadius(){
        return this.radius;
    }
    public String getColor(){
        return this.color;
    }

}
