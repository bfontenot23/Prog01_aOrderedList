public class Car implements Comparable<Car>{

    private String make;
    private int year;
    private int price;

    public Car(String make, int year, int price)
    {
        this.make = make;
        this.year = year;
        this.price = price;
    }

    public String getMake()
    {
        return make;
    }

    public int getYear()
    {
        return year;
    }

    public int getPrice()
    {
        return price;
    }


//TODO: fix whatever the fuck i was doing here
    public int compareTo(Car other)
    {
        if(this.make.compareTo(other.getMake()) < 0)
        {
            return this.make.compareTo(other.getMake());
        }
        else if(this.make.compareTo(other.getMake()) == 0 && Integer.compare(this.year, other.getYear()) < 0)
        {
            return Integer.compare(this.year, other.getYear());
        }
        else if(this.make.compareTo(other.getMake()) == 0 && Integer.compare(this.year, other.getYear()) == 0)
        {
            return this.make.compareTo(other.getMake());
        }
        else return 1;
    }

    public String toString()
    {
        return String.format("Make: %s, Year: %d, Price: %d", this.make, this.year, this.price);
    }
}
