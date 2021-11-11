package _6_inherite_java.practice;

public class Circle2Test {
    public static void main(String[] args) {
        Circle2 circle2 = new Circle2();
        System.out.println(circle2);
        circle2 = new Circle2(3,"red");
        System.out.println(circle2);
        System.out.println(circle2 + "thong tin la " + circle2.toString());
    }
}
