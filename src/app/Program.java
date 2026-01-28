package app;

import entities.AbstractShape;
import entities.Color;
import entities.Shape;
import entities.Square;

public class Program {
    public static void main(String[] args) {
        Shape shape = new Square(Color.WHITE);
        AbstractShape shape2 = new Square(Color.BLACK);

        System.out.println(shape2.area()); // Don't have access about color
        System.out.println(shape2.getColor()); // have access color because is abstractShape
    }
}
