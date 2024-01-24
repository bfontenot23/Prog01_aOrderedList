import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Prog01_aOrderedList {

    static Scanner in = new Scanner(System.in);

    public static Scanner getInputFile() throws FileNotFoundException
    {
        //File file = new File(userPrompt);
        File file;
        boolean validFile = false;
        String filename, filepath;
        do {
            System.out.print("\nEnter input filename: ");
            filename = in.next();
            if(!filename.startsWith(":\\", 1)) filepath = ".\\src\\" + filename;
            else filepath = filename;
            file = new File(filepath);
            if(!file.exists())
            {
                System.out.printf("\nFile specified <%s> does not exist in the src folder.  Would you like to continue? <Y/N> ", filename);
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
        //File file = new File(userPrompt);
        File file;
        boolean validFile = false;
        String filename, filepath;
        do {
            System.out.print("\nEnter output filename: ");
            filename = in.next();
            if(!filename.startsWith(":\\", 1)) filepath = ".\\src\\" + filename;
            else filepath = filename;
            file = new File(filepath);
            if(!file.exists() || !file.canWrite())
            {
                System.out.printf("\nFile specified <%s> does not exist in the src folder or is unable to be written to.  Would you like to continue? <Y/N> ", filename);
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


    public static void main(String[] args)
    {

        Scanner file = null;
        PrintWriter outputFile = null;
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
                String[] lineSeparated = line.split(",");

                //add cars to aOrderedList here
                if(lineSeparated[0].equals("A")) cars.add(new Car(lineSeparated[1],Integer.parseInt(lineSeparated[2]),Integer.parseInt(lineSeparated[3])));
            }
            else done = true;
        }while(!done);

        outputFile.write(cars.toString());
        outputFile.close();
    }
}
