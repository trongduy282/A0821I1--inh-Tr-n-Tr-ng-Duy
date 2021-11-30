package _11_Stack_Queue.exersice;

import java.util.Locale;
import java.util.TreeMap;

public class TestTreeMap{
    public static void main(String[] args) {
        String s1="Hello";
        String s= s1.toLowerCase();
        TreeMap<Character,Integer> map = new TreeMap<>();
        for(int i=0; i<s.length();i++){
            if(map.containsKey(s.charAt(i))){
                map.put(s.charAt(i), map.get(s.charAt(i))+1);
            }
            else map.put(s.charAt(i),1);
        }
        System.out.println(map);
    }
}
