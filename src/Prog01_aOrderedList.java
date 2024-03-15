/**
 * main driver class containing methods for getting input and output files and parsing each line of the input file as well as the main method
 *
 * CSC 1351 Programming Project No 1
 7
 * Section 002
 *
 * @author Beau Fontenot
 * @since 03-17-24
 *
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Prog01_aOrderedList {

    static Scanner in = new Scanner(System.in);

    public static Scanner getInputFile() throws FileNotFoundException
    {
        File file;
        boolean validFile = false;
        String filename, filepath;
        System.out.println();
        do {
            System.out.print("\nEnter input filename: ");
            filename = in.next();
            if(!filename.startsWith(":\\", 1) && !filename.startsWith(".\\") && !filename.startsWith(":/", 1) && !filename.startsWith("./") && !filename.startsWith("\\") && !filename.startsWith("/")) filepath = "./" + filename;
            else filepath = filename;
            file = new File(filepath);
            if(!file.exists())
            {
                // NOTE: THIS ERROR MAY RUN IF FOR WHAT EVER REASON WINDOWS DOESN'T LIKE FORWARD SLASH FILEPATHS
                System.out.printf("\nFile specified <%s> does not exist in the project folder.  Would you like to continue? <Y/N> ", filename);
                if(in.next().equals("N"))
                {
                    throw new FileNotFoundException();
                }
            }
            else
            {
                validFile = true;
            }
        }while(!validFile);

        return new Scanner(file);
    }


    public static PrintWriter getOutputFile() throws FileNotFoundException
    {
        File file;
        boolean validFile = false;
        String filename, filepath;
        do {
            System.out.print("\nEnter output filename: ");
            filename = in.next();
            if(!filename.startsWith(":\\", 1) && !filename.startsWith(".\\") && !filename.startsWith(":/", 1) && !filename.startsWith("./") && !filename.startsWith("\\") && !filename.startsWith("/")) filepath = "./" + filename;
            else filepath = filename;
            file = new File(filepath);
            if(!file.exists() || !file.canWrite())
            {
                // NOTE: THIS ERROR MAY RUN IF FOR WHAT EVER REASON WINDOWS DOESN'T LIKE FORWARD SLASH FILEPATHS
                System.out.printf("\nFile specified <%s> does not exist in the project folder or is unable to be written to.  Would you like to continue? <Y/N> ", filename);
                if(in.next().equals("N"))
                {
                    throw new FileNotFoundException();
                }
            }
            else
            {
                validFile = true;
            }
        }while(!validFile);

        return new PrintWriter(file);
    }

    public static void parseLine(String cmdS, aOrderedList list)
    {
        String[] cmd = cmdS.split(",");

        if(cmd.length!=1) {
            switch (cmd[0]) {
                case "A":
                    //Test for correct param inputs
                    if (cmd.length == 4) {
                        try {
                            list.add(new Car(cmd[1], Integer.parseInt(cmd[2]), Integer.parseInt(cmd[3])));
                        } catch (
                                NumberFormatException e) //occurs when either parameter 3 (year) or 4 (price) are not integers
                        {
                            System.out.println("! Inputted parameters could not be parsed correctly.");
                            break;
                        }
                    } else {
                        if (cmd.length < 4)
                            System.out.println("! Missing parameters. (need 4, provided " + cmd.length + ")");
                        else System.out.println("! Too many parameters. (need 4, provided " + cmd.length + ")");
                    }
                    break;
                case "D":
                    int index;
                    //test for which instance of D is being submitted
                    try {
                        index = Integer.parseInt(cmd[1]);

                        //If the code makes it to this point, the case being submitted is that which only an index is supplied.
                        //Test for correct param inputs

                        if (cmd.length == 2) list.remove(index);
                        else {
                            if (cmd.length < 2)
                                System.out.println("! Missing parameters. (need 2, provided " + cmd.length + ")");
                            else System.out.println("! Too many parameters. (need 2, provided " + cmd.length + ")");
                        }
                        break;
                    } catch (NumberFormatException e) {
                    /*
                    Will run if the first parameter is NOT an integer.
                    Note that I'm purposefully causing an error to check
                    if there is an integer or not, and this should not
                    be viewed as error handling.
                     */
                        //If the code makes it to this point, the case being submitted is that which a car make and year is given.

                        //Set up test case variables
                        String make = cmd[1];
                        int year;
                        try {
                            year = Integer.parseInt(cmd[2]);
                        } catch (NumberFormatException f) //Occurs when parameter 3 (year) is not an integer
                        {
                            System.out.println("! Inputted parameters could not be parsed correctly.");
                            break;
                        }

                        //Iterate through list to find a match.
                        Object temp;
                        Car car = null;
                        boolean done = false;
                        list.reset(); //precautionary reset

                        while (list.hasNext() && !done) {
                            temp = list.next();

                            if (temp instanceof Car) {
                                car = (Car) temp;

                                if (car.getMake().equals(make) && car.getYear() == year) {
                                    //found car
                                    list.remove();
                                    done = true;
                                }
                            }
                        }
                        //code here will occur after everything in the list has been iterated through
                        //usually I'd put an error here to show that no car is found but as per the instructions I will not
                    }
                    break;
            }
        }
        else { System.out.println("! No parameters provided after operation."); }
    }


    public static void main(String[] args)
    {
        Scanner file;
        PrintWriter outputFile;
        try
        {
            file = getInputFile();
            outputFile = getOutputFile();
        } catch (FileNotFoundException e)
        {
            return;
        }
        aOrderedList cars = new aOrderedList();


        boolean done = false;
        do {
            if(file.hasNextLine())
            {
                String line = file.nextLine();
                parseLine(line, cars);
            }
            else done = true;
        }while(!done);

        outputFile.write(cars.toString());
        outputFile.close();
    }
}

