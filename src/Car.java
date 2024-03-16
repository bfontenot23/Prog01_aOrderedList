/**
 * Car class creates car objects with make, year, and price as parameters
 *
 * CSC 1351 Programming Project No 1
 7
 * Section 002
 *
 * @author Beau Fontenot
 * @since 03-17-24
 *
 */

public class Car implements Comparable<Car>{

    private final String make;
    private final int year;
    private final int price;

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


    public int compareTo(Car other)
    {
        if(this.make.compareTo(other.getMake())==0) return Integer.compare(this.year, other.getYear());
        else return this.make.compareTo(other.getMake());
    }

    public String toString()
    {
        String temp = String.format( "$%,d", this.price );
        String price = String.format("%-13s%7s%n", "Price:", temp);
        return String.format("\nMake: %14s\nYear: %14d\n%s", this.make, this.year, price);
    }
}
