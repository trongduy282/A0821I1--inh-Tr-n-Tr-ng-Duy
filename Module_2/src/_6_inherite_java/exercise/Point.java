package _6_inherite_java.exercise;

public class Point {
    private float x = 0.0f;
    private float y = 0.0f;
    Point(){}
    Point(float x, float y){
        this.x=x;
        this.y=y;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }
    public void setXY(float x, float y){
        this.x =x;
        this.y =y;
    }
    public float[] getXY(){
        float[] res ={x,y};
        return res;
    }
    public String toString(){
        return "(x: " + getX()+ ",y: "+getY()+")";
    }
}
