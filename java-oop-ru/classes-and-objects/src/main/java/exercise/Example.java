package exercise;

public class Example {
    public static void main(String[] args) {
        final int x1 = 4;
        final int y1 = 3;
        final int x2 = 6;
        final int y2 = 1;
        Point point1 = new Point(x1, y1);
        Point point2 = new Point(x2, y2);
        Segment segment = new Segment(point1, point2);
        Point midPoint = segment.getMidPoint();
        System.out.println(midPoint.getX()); // 5
        System.out.println(midPoint.getY()); // 2
    }
}
