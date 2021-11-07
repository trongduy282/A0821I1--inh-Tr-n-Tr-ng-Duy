package _5_access_modifier_static_java.practice;

public class Car {
    public static int nunberOfCars;
    private String name;
    private String engine;
    public Car(){};
    public Car(String name, String engine){
this.name = name;
this.engine =engine;
nunberOfCars++;
    }
}
