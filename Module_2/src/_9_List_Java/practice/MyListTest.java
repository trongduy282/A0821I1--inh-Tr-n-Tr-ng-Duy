package _9_List_Java.practice;

public class MyListTest {
    public static void main(String[] args) {
        MyList<Integer> listInteger = new MyList<>();
        listInteger.add(1);
        listInteger.add(2);
        listInteger.add(3);
        listInteger.add(4);//SAO KO THÊM ĐƯỢC PHẦN TỬ THỨ TƯ TA, CAPACITY LÀ 10 MÀ, VS CÓ CẢ CÁI METHOD ENSURECAPA MÀ??
        //System.out.println("element 4: " + listInteger.get(4));
        System.out.println("element 1: " + listInteger.get(1));
        System.out.println("element 2: " + listInteger.get(2));
//        listInteger.get(-1);
//        System.out.println("element -1: " + listInteger.get(-1));
    }
}
