package entities;

public class Square extends AbstractShape {

    public Square(Color color) {
        super(color);
    }

    @Override
    public double area() {
        return 20.0;
    }
}
