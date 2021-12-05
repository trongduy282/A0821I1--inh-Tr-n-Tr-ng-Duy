package _15_Exception_java.exersice;

public class IllegalTriangleException extends RuntimeException {
    public IllegalTriangleException(String errorMessage) {
        super(errorMessage);
    }
}