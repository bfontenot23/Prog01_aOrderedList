public class Car {

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

    // 0 = this car is worse.  1 = this car is better
    public int compareTo(Car other)
    {
        /*
        if(this.make < other.getMake())
        {

        }*/
        if(this.year < other.getYear()) return 0;

        return 1;
    }

    public String toString()
    {
        return String.format("Make: %s, Year: %d, Price: %d", this.make, this.year, this.price);
    }
}
