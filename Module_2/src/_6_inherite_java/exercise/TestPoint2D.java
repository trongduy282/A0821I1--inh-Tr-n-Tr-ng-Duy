package _6_inherite_java.exercise;

import java.util.Arrays;

public class TestPoint2D {
    public static void main(String[] args) {
        Point2D point2D= new Point2D(2,3);
        System.out.println(point2D);
        float[] tmp= point2D.getXY();
        System.out.println(Arrays.toString(tmp));

    Point3D point3D= new Point3D(4,5,6);
        System.out.println(point3D);
    float[] res= point3D.getXYZ();
        System.out.println(Arrays.toString(res));
}
}
