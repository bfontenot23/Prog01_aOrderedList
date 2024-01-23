import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Prog01_aOrderedList {

    public static Scanner getInputFile(String userPrompt) throws FileNotFoundException{
        File file = new File(userPrompt);
        return new Scanner(file);
    }


    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        Scanner file = new Scanner("");

        boolean validFile = false, forced = false;
        String filename, filepath;
        do {
            System.out.print("\nEnter input filename: ");
            filename = in.next();
            filepath = "./src/" + filename;
            try
            {
                file = getInputFile(filepath);
                validFile = true;
            }
            catch(FileNotFoundException e)
            {
                System.out.printf("\n File specified <%s> does not exist.  Would you like to continue? <Y/N> ", filename);
                if(in.next().equals("N"))
                {
                    validFile = true;
                    forced = true;
                }
            }
        }while(!validFile);


        if(!forced)
        {
            boolean done = false;
            do {
                if(file.hasNextLine())
                {
                    String line = file.nextLine();
                    String[] lineSeparated = line.split(",");

                    //add cars to aOrderedList here
                }
                else done = true;
            }while(!done);
        }
    }
}
