package exercise;

// BEGIN
public class Circle {
    private Point pointOfCircle;
    private int radiusOfCircle;

    public Circle(Point pointCircle, int radiusCircle) {
        this.pointOfCircle = pointCircle;
        this.radiusOfCircle = radiusCircle;
    }

    public int getRadius() {
        return radiusOfCircle;
    }

    public double getSquare() throws NegativeRadiusException {
        final int quad = 2;
        int radius = getRadius();
        if (radius < 0) {
            throw new NegativeRadiusException("Не удалось посчитать площадь");
        }
        return (Math.PI * Math.pow(radius, quad));
    }

}
// END
