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
        //sort();
    }

    public void sort()
    {
        //code
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
