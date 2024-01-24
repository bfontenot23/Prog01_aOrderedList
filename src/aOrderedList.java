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
        this.oList[numObjects] = newCar;
        numObjects++;
        sort();
    }

    public void sort()
    {
        Car current = null;
        Car next = null;
        boolean swapped = false;
        boolean done = false;

        while(!done)
        {
            swapped = false;
            for(int i = 0; i < oList.length-1; i++)
            {
                if(oList[i+1]!=null)
                {
                    if (oList[i].compareTo(oList[i + 1]) == 1)
                    {
                        current = oList[i];
                        next = oList[i + 1];
                        oList[i] = next;
                        oList[i + 1] = current;
                        swapped = true;
                    }
                }
            }
            if(!swapped) done = true;
        }
    }

    public String toString()
    {
        StringBuilder output = new StringBuilder();
        for(Car car: this.oList)
        {
            if(car!=null)
            {
                output.append("[");
                output.append(car.toString());
                output.append("]");
            }
        }

        return output.toString();
    }
}
