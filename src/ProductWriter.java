import javax.swing.*;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ProductWriter
{
    public static void main(String[] args)
    {
        String ID = "";
        String fName = "";
        String description = "";
        double cost = 0;
        boolean done = false;

        ArrayList<String> personsData = new ArrayList<String>();
        Scanner in = new Scanner(System.in);

        do {
            ID = SafeInput.getRegExString(in, "Enter a 6-digit id", "" + "\\d{6}");
            fName = SafeInput.getNonZeroLenString(in, "What is the name");
            description = SafeInput.getNonZeroLenString(in, "What is the description");
            cost = SafeInput.getDouble(in, "What is the cost");
            done = SafeInput.getYNConfirm(in, "Are you done entering prompts?");

            personsData.add(ID + ", " + fName + ", " + description + ", " + cost);
        } while(!done);

        try {
            FileWriter myWriter = new FileWriter("ProductsDataFile.txt");
            for(int i = 0; i < personsData.size(); i++) {
                myWriter.write(personsData.get(i) + "\n");
            }
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }
}
