package _3_array_java.practice;

public class FindMin {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int index= minValue(arr);
        System.out.println("Giá trị nhỏ nhất là " + arr[index]);
    }

    public static int minValue(int[] arr) {
        int index = 0;
        for (int i = 1; i < arr.length; i++) {
         if(arr[i]<arr[index]){
             index=i;
         }
        }
        return index;
    }

}
