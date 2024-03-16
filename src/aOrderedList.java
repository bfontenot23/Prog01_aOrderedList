/**
 * aOrderedList class for creating the ordered list objects
 *
 * CSC 1351 Programming Project No 1
 7
 * Section 002
 *
 * @author Beau Fontenot
 * @since 03-17-24
 *
 */

import java.util.Arrays;
import java.util.Comparator;

public class aOrderedList {

    private final int SIZEINCREMENTS = 20;
    private Comparable[] oList;
    private int listSize;
    private int numObjects;
    private int curr;

    public aOrderedList()
    {
        this.numObjects = 0;
        this.listSize = SIZEINCREMENTS;
        this.oList = new Comparable[SIZEINCREMENTS];
        this.curr = -1; //because the list starts at index 0, the current value will be -1 until this.next() is called.
    }

    public void add(Comparable newObj)
    {
        if(numObjects%20 == 0) { this.oList = Arrays.copyOf(this.oList, this.oList.length + SIZEINCREMENTS); listSize = this.oList.length; }
        this.oList[numObjects] = newObj;
        numObjects++;
        Arrays.sort(this.oList, Comparator.nullsLast(Comparator.naturalOrder())); //Comparator.nullsLast(Comparator.naturalOrder()) forces null values to the end of the array
    }

    public String toString()
    {
        StringBuilder output = new StringBuilder();
        output.append(String.format("Number of cars:%7d\n", numObjects));
        for(Comparable obj: this.oList)
        {
            if(obj!=null)
            {
                output.append(obj);
            }
        }

        return output.toString();
    }

    public int size() { return numObjects; }

    public Comparable get(int index) throws IndexOutOfBoundsException
    {
        if(index < oList.length && index >= 0)
        {
            if(oList[index] != null) return oList[index];
            else
            {
                System.out.println("! There was no object at the specified index.");
                return null;
            }
        }
        else throw new IndexOutOfBoundsException();
    }

    public boolean isEmpty()
    {
        return oList[0] == null;
    }

    public void remove(int index) throws IndexOutOfBoundsException
    {
        if(index < oList.length && index >= 0)
        {
            if(oList[index] != null)
            {
                for (int i = index; i < oList.length; i++)
                {
                    if (i + 1 != oList.length)
                    {
                        if (oList[i + 1] != null) oList[i] = oList[i + 1];
                        else oList[i] = null;
                    }
                }
                numObjects--;
                if (numObjects % 20 == 0) { this.oList = Arrays.copyOf(this.oList, this.oList.length - SIZEINCREMENTS); listSize = this.oList.length; }

                Arrays.sort(this.oList, Comparator.nullsLast(Comparator.naturalOrder())); //Comparator.nullsLast(Comparator.naturalOrder()) forces null values to the end of the array
            }
            else System.out.println("! The object at the specified index does not exist.");
        }
        else throw new IndexOutOfBoundsException();
    }

    public void reset(){ curr = -1; }

    public Comparable next(){
        curr++;
        return this.get(curr);
    }

    public boolean hasNext(){
        return oList[curr+1]!=null;
    }

    public void remove(){
        if(curr>=0) remove(curr);
    }
}
