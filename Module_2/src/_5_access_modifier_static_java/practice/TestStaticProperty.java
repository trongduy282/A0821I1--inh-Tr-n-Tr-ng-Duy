package _5_access_modifier_static_java.practice;

public class TestStaticProperty {
    public static void main(String[] args) {
        Car car1 = new Car("Duy","dong co1");
        System.out.println(Car.nunberOfCars);
        Car car2 = new Car("Hang","dong co2");
        System.out.println(Car.nunberOfCars);
    }
}
