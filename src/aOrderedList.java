import java.util.Arrays;
import java.util.Comparator;

public class aOrderedList {

    private final int SIZEINCREMENTS = 20;
    private Car[] oList;
    private int listSize;
    private int numObjects;

    public aOrderedList()
    {
        this.numObjects = 0;
        this.listSize = SIZEINCREMENTS;
        this.oList = new Car[SIZEINCREMENTS];
    }

    public void add(Car newCar)
    {
        if(numObjects%20 == 0) this.oList = Arrays.copyOf(this.oList, this.oList.length + SIZEINCREMENTS);
        this.oList[numObjects] = newCar;
        numObjects++;
        Arrays.sort(this.oList, Comparator.nullsLast(Comparator.naturalOrder()));
    }

    public String toString()
    {
        StringBuilder output = new StringBuilder();
        for(Car car: this.oList)
        {
            if(car!=null)
            {
                output.append("[");
                output.append(car);
                output.append("]");
            }
        }

        return output.toString();
    }

    public int size() { return numObjects; }

    public Car get(int index)
    {
        try
        {
            if(oList[index] != null) return oList[index];
            else
            {
                System.out.println("! There was no car at the specified index.  Returning the first car instead.");
                return oList[0];
            }
        }
        catch (IndexOutOfBoundsException e)
        {
            System.out.println("! The specified index is out of bounds!  Returning the first car instead.");
            return oList[0];
        }
    }

    public boolean isEmpty()
    {
        return oList[0] == null;
    }

    public void remove(int index)
    {
        //TODO: ensure that the object at the specified index isn't null to begin with.
        for(int i = index; i < oList.length; i++)
        {
            if(i+1 != oList.length)
            {
                if (oList[i + 1] != null) oList[i] = oList[i + 1];
                else oList[i] = null;
            }
        }
        numObjects--;
        if(numObjects%20==0) this.oList = Arrays.copyOf(this.oList, this.oList.length - SIZEINCREMENTS);
    }
}
