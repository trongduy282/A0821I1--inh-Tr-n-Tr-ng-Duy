package _7_abstract_interface.practice.model;

import _7_abstract_interface.practice.service.IEdible;

public class Chicken extends Animal implements IEdible {
    public String makeSound(){
        return "chicken: O o o";
    }
    public String howtoEat(){
        return "could be fried";
    }
}
