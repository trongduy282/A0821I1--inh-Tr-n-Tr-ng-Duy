package _3_array_java.practice;

import java.util.Scanner;

public class Temperature {
    public static void main(String[] args) {
        Temperature temperature = new Temperature();
        double celsius;
        double fahrenheit;
        int choice;
        Scanner scanner = new Scanner(System.in);


        do {
            System.out.println("Menu");
            System.out.println("1. Fahrenheit to Celsius");
            System.out.println("2. Celsius to Fahrenheit");
            System.out.println("0. Exit ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter Fahrenheit:");
                    fahrenheit = scanner.nextDouble();
                    System.out.println("Fahrenheit to Celsius: " + temperature.fahrenheitToCelsius(fahrenheit));
                    break;
                case 2:
                    System.out.println("Enter Celsius: ");
                    celsius = scanner.nextDouble();
                    System.out.println("Celsius to Fahrenheit: " + temperature.celsiusToFahrenheit(celsius));
                    break;
                case 0:
                    System.exit(0);
            }
        }
        while (choice != 0);
    }
        public double celsiusToFahrenheit(double celsius) {
            double fahrenheit = (9.0 / 5) * celsius + 32;
            return fahrenheit;
        }
        public double fahrenheitToCelsius(double fahrenheit) {
            double celsius = (5.0 / 9) * (fahrenheit - 32);
            return celsius;
        }
    }

