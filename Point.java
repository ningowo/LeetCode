import java.io.Serializable;

/**
 * @Author: Yizhen Yuan
 * @Date: 2020.06.28
 * @Description:
 */
public class Point implements Comparable<Point>,Serializable{
    private static final long serialVersionUID=20200628;
    final int x;
    final int y;
    static int bound = 1000;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Point() {
        if (bound < 10) bound = 10;
        this.x = (int) (Math.random() * 2 * bound - bound);
        this.y = (int) (Math.random() * 2 * bound - bound);
    }

    @Override
    public String toString() {
        return "point{" + x + "," + y + "}";
    }

    public double distance(Point e) {
        return Math.sqrt(Math.pow(x - e.x, 2) + Math.pow(y - e.y, 2));
    }

    public static double distance(Point[] points){
        assert points.length==2;
        return points[0].distance(points[1]);
    }
    @Override
    public boolean equals(Object obj) {
        assert obj instanceof Point;
        return ((Point) obj).x==x&&((Point) obj).y==y;
    }

    @Override
    public int compareTo(Point o) {
        return o.x-x;
    }
}

