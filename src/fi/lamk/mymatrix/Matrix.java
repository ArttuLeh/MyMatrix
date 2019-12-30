/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.lamk.mymatrix;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 *
 * @author Arttu Lehtovaara
 */
public class Matrix 
{
    private Map<Point, Integer> matrix = new TreeMap<>();
    public void set(int x, int y, int value)
    {
        Point p = new Point(x, y);
        int oldValue = get(x, y);
        if (value == 0) // zeros will not be added!
        {
            if (oldValue != 0) // but we should remove the possible old value
                matrix.remove(p);
            return;
        }
        // whether or not there was oldvalue, put() adds new  or replaces old
        matrix.put(p, value);
    }
    public int get(int x, int y)
    {
        Point p = new Point(x, y);
        Integer value;
        if ((value = matrix.get(p)) == null)
            return 0;
        return value; // implicit conversion from Integer --> int
    }
    void product(int coefficient)
    {
        // first is to decide what to do with coefficient == 0..
        if (coefficient == 0)
        {
            //matrix.clear(); // if we want to multiply by zero
            return;
        }
        // less effective since the matrix entries are read several times..
//        Set<Point>keys = matrix.keySet();
//        for(Point p : keys)
//        {
//            matrix.replace(p, matrix.get(p)*coefficient);
//        }
        // more effective since entries are read just once
        Set<Map.Entry<Point, Integer>> mes = matrix.entrySet();
        for (Map.Entry<Point, Integer> me : mes)
        {
            me.setValue(me.getValue()*coefficient);
        }
    }
    boolean sum(Matrix other)
    {
        // 1)use getRowCount() and getColCount() fist to check if matrix "this"
        // and "other" has equal dimensions.. if not return false
        if ((getRowCount() != other.getRowCount()) || getColCount() != other.getColCount())
            return false;
        // 2) create nested for loops and use our own get() function for "this"
        // and "other" and make the additions and then call our own set().. why?
        // because value+value2 can be zero!!
        for (int i = 0; i < getRowCount(); i++) 
        {
            for (int j = 0; j < getColCount(); j++) 
            {
                get(j, i);
                other.get(j, i);
                get(j, i + other.get(j, i));
                set(j, i, get(j, i) + other.get(j, i));
                System.out.print(get(j, i) + " ");
            }
            System.out.println();
        }
        return true;
    }
    int getRowCount()
    {
        int maxY = -1;
        // use KeySet() for getting all the keys and check what is the max..
        
        //Set<Point> keys = matrix.keySet();
        for (Point p : matrix.keySet())
        {
            if (p.getY() > maxY)
            {
                maxY = p.getY();
            }
        }
        return maxY + 1;
    }
    int getColCount()
    {
        int maxX = -1;
        // use KeySet() for getting all the keys and check what is the max..
        for (Point px : matrix.keySet())
        {
            if (px.getX() > maxX)
            {
                maxX = px.getX();
            }
        }
        return maxX + 1;
    }
    void print()
    {
        // use getRowCount() and the getColCount() for the for nested loops..
        int rows = getRowCount();
        int cols = getColCount();
        for (int i = 0; i < rows; i++) // all the rows..
        {
            for (int j = 0; j < cols; j++) // all the columns..
            {
                // use our own get() to get the values (including zeros)
                System.out.print(get(j, i) + " ");
            }
            System.out.println();
        }
    }
}
