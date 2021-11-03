package _3_array_java.exercise;

public class MaxInArray {
    public static void main(String[] args) {
        int[][] arr = {
                {1,2,3},
                {4,5,6},
                {7,8,9},
                {10,11,12}
        };
        int max =arr[0][0];
        for(int i=0; i<4;i++){
            for(int j =0; j<3;j++){
                if(arr[i][j]>max){
                    max= arr[i][j];
                }
            }
        }
        System.out.println(max);
    }
}
