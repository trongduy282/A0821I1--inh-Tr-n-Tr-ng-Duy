package _4_class_object.practice;


public class QuadraticEquation {
    public double a,b,c;
    public QuadraticEquation(){}
   public QuadraticEquation(double a,double b,double c ){
this.a =a;
this.b =b;
this.c=c;
   }
   public double getA(){
       return this.a;
   }
    public double getB(){
        return this.b;
    }
    public double getC(){
       return this.c;
    }
    public double getDiscriminant(){
       return b*b- 4*a*c;
    }
    public double getRoot1(){
        if(this.getDiscriminant()<0) return 0;
       return (-b + Math.pow(b*b- 4*a*c,0.5))/2*a;
    }
    public double getRoot2(){
        if(this.getDiscriminant()<0) return 0;
        return (-b - Math.pow(b*b- 4*a*c,0.5))/2*a;
    }
}
