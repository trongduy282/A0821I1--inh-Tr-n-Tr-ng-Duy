package _9_List_Java.exersice;


import java.util.Arrays;

public class MyList<E> {
    /*private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;
    private Object elements[];

    public MyList() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    public MyList(int capacity) {
        elements = new Object[capacity];
    }

    private void ensureCapa() {
        int newSize = elements.length * 2;
        elements = Arrays.copyOf(elements, newSize);
    }

    public void add(int index, E element) {
        if (size == elements.length) {
            ensureCapa();
        }
        for (int i = size - 1; i >= index; i--) {
            elements[i + 1] = elements[i];
        }
        elements[index] = element;

    }

    private void checkIndex(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size " + index);
        }
    }

    public E remove(int index) {
        checkIndex(index);
        for (int j = index; j < size - 1; j++)
            elements[j] = elements[j + 1];
        elements[size - 1] = null;
        size--;
        return elements[index];
    }

    public int size() {
        return size;
    }

    public E clone() {
        E[] cloneArray = Arrays.copyOf(elements, size);
        ;
        return (E) cloneArray;
    }

    public boolean contain(E o) {
        for (int i = 0; i < size; i++)
            if (o.equals(elements[i]))
                return true;
        return false;
    }
    public int indexOf(E o){
        for (int i = 0; i < size; i++)
            if (o.equals(elements[i])) return i;
        return -1;
    }
    private void ensureCapa(int minCapacity){
        int newSize = elements.length*2;
        elements = Arrays.copyOf(elements, minCapacity);
    }
    public E get(int index) {
        checkIndex(index);
        return elements[index];
    }
    public void clear() {
        elements = (E[]) new Object[DEFAULT_CAPACITY];
        size = 0;
    }*/
}
