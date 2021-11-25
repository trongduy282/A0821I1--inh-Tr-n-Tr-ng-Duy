package _11_Stack_Queue.exersice;

import java.util.Stack;

public class ReversinStringArrayUsingStack {
    public static void main(String[] args) {

        Stack<Character> stack = new Stack<>();
        String string1 = "abcde";
        for (int i=0;i<string1.length();i++){
            stack.push(string1.charAt(i));
        }
        System.out.println(stack);
        String string2 ="";
        for (int i=0;i<string1.length();i++){
            string2 += stack.pop();
        }
        System.out.println(string2);
    }
}
