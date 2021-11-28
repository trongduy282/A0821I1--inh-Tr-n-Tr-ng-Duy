package _6_inherite_java.exercise;

public class Cylinder extends Circle2 {
    private double height;
    Cylinder(){
    }
    Cylinder(double radius, String color, double height){
        super(radius,color);
        this.height =height;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
    public double getVolume(){
        return super.getArea()*this.height;
    }
    public String toString(){
        return "Hình trụ có chiều cao là " + getHeight() + "và lớp con của" + super.toString();
    }
}
