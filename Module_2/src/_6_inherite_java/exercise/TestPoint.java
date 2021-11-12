package _6_inherite_java.exercise;

import java.util.Arrays;

public class TestPoint {
    public static void main(String[] args) {
        Point point =new Point(3,5);
        System.out.println(point);
        float[] tmp = point.getXY();
        for(int i =0;i<tmp.length;i++){
            System.out.println(tmp[i]);
        }
        MovablePoint movablePoint = new MovablePoint(4,5,7,8);
        System.out.println(movablePoint);
        float[] move1 = movablePoint.getSpeed();
        System.out.println(Arrays.toString(move1));
    }
}
