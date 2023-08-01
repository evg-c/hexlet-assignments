package exercise;

// BEGIN
public final class Flat implements Home {
    private double area;
    private double balconyArea;
    private int floor;
    public Flat(double areaFlat, double balconyAreaFlat, int floorFlat) {
        this.area = areaFlat;
        this.balconyArea = balconyAreaFlat;
        this.floor = floorFlat;
    }
    public Flat() {
    }
    @Override
    public double getArea() {
        return (this.area + this.balconyArea);
    }
    public String toString() {
        if (this.area == 0) {
            return null;
        }
        return "Квартира площадью " + getArea() + " метров на " + floor + " этаже";
    }
    @Override
    public int compareTo(Home another) {
        if ((area == 0) && (another == null)) {
            return 0;
        }
        if (another == null) {
            return 1;
        }
        if (getArea() > another.getArea()) {
            return 1;
        }
        if (getArea() < another.getArea()) {
            return -1;
        }
        return 0;
    }
}
// END
