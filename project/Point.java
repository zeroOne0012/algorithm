package project;

public class Point{
    public int x;
    public int y;

    Point(int x, int y){
        this.x = x;
        this.y = y;
    }

    public Point add(Point other){
        x += other.x;
        y += other.y;
        return this;
    }

    public boolean equal(Point other){
        return x == other.x && y == other.y;
    }
    
};
