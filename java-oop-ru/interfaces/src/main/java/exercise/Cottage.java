package exercise;

// BEGIN
public final class Cottage implements Home {
    private double area;
    private int floorCount;
    public Cottage(double areaCottage, int floorCountCottage) {
        this.area = areaCottage;
        this.floorCount = floorCountCottage;
    }
    public Cottage() {
    }
    @Override
    public double getArea() {
        return area;
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
    public String toString() {
        if (this.area == 0) {
            return null;
        }
        return floorCount + " этажный коттедж площадью " + getArea() + " метров";
    }
}
// END
