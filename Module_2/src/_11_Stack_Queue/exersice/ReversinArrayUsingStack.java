package _11_Stack_Queue.exersice;

import java.util.Stack;

public class ReversinArrayUsingStack<E> {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        int[] arrInteger = {1,2,3,4,5};
        for(int i=0; i<arrInteger.length;i++){
            stack.push(arrInteger[i]);
        }
        System.out.println(stack);
        for(int i=0; i<arrInteger.length;i++){
            arrInteger[i]= stack.pop();
        }
        for(int i=0; i<arrInteger.length;i++){
            System.out.println(arrInteger[i]);
        }
    }
}
