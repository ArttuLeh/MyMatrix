/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.lamk.mymatrix;

/**
 *
 * @author Arttu Lehtovaara
 */
public class Point implements Comparable<Point>
{
    private int x;
    private int y;

    public Point()
    {
        this(0, 0);
    }
    public Point(int x, int y)
    {
        setX(x);
        setY(y);
    }

    @Override
    public String toString() 
    {
        return "("+ getX() +","+ getY() +")";
    }
    
    /**
     * @return the x
     */
    public int getX() 
    {
        return x;
    }

    /**
     * @param x the x to set
     */
    public void setX(int x) 
    {
        this.x = x;
    }

    /**
     * @return the y
     */
    public int getY() 
    {
        return y;
    }

    /**
     * @param y the y to set
     */
    public void setY(int y) 
    {
        this.y = y;
    }

    @Override
    public int compareTo(Point t) 
    {
        if (this.x < t.x) return -1;
        if (this.x > t.x) return 1;
        // x:s are equal..
        if (this.y < t.y) return -1;
        if (this.y > t.y) return 1;
        // y:s are also equal..
        return 0;
    }
}
