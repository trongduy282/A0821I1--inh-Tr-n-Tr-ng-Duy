package _6_inherite_java.exercise;

public class MovablePoint extends Point{
    private float xSpeed;
    private float ySpeed;
    public MovablePoint(){}
    public MovablePoint(float xSpeed, float ySpeed){
        this.xSpeed =xSpeed;
        this.ySpeed =ySpeed;
    }
    public MovablePoint(float x,float y, float xSpeed, float ySpeed){
        super(x,y);
        this.xSpeed =xSpeed;
        this.ySpeed =ySpeed;
    }

    public float getxSpeed() {
        return xSpeed;
    }

    public void setxSpeed(float xSpeed) {
        this.xSpeed = xSpeed;
    }

    public float getySpeed() {
        return ySpeed;
    }

    public void setySpeed(float ySpeed) {
        this.ySpeed = ySpeed;
    }
    public void setSpeed(float xSpeed, float ySpeed){
        this.xSpeed =xSpeed;
        this.ySpeed=ySpeed;
    }
    public float[] getSpeed(){
        float[] res = {xSpeed,ySpeed};
        return res;
    }
    public String toString(){
        return "xSpeed: " + getxSpeed() + ", ySpeed: " + getySpeed()+ super.toString();
    }
}
