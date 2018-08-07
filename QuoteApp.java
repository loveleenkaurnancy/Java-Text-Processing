import java.util.ArrayList;
import java.util.List;
import java.io.*;
import java.util.*;
import java.util.Scanner;

public class QuoteApp {
    public static void main(String[] args) {
        // Create all objects and call all methods that you
        // need here. You have freedom as to how you want to
        // interact with the user.
        // The name of the file to open.

        Scanner input = new Scanner(System.in);

        String fileName = "favorite.txt";

        // This will reference one line at a time
        String line = null;

        try {

            // #region Reading Quotes From File in main method
            // FileReader reads text files in the default encoding.
            FileReader fileReader = new FileReader(fileName);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            System.out.println("*****Reading Quotes from file*****");
            while ((line = bufferedReader.readLine()) != null) {

                System.out.println(line);

            }
            System.out.println("*****End of Quotes*****");
            // Always close files.
            bufferedReader.close();
            // #endregion

            // #region Counting Quotes From file Calling from QuoteFile.Class
            QuoteFile myQuoteFile = new QuoteFile(fileName);
            int count = myQuoteFile.countQuotes();
            System.out.println("\n");
            System.out.println("Number of Quotes available in files are: " + count);
            // #endregion

            // #region calling method for Adding Quotes to file
            System.out.println("Enter Quote " );
            String data = input.next();
            AddQuotesToFile(fileName, data);
            // #endregion

            // #region Reading nth number of text from file
            Scanner in = new Scanner(System.in);
            System.out.print("Input a number: ");
            int n = in.nextInt();
            retrieveQuote(n);
            // #endregion

        } catch (FileNotFoundException ex) {
            System.out.println("Unable to open file '" + fileName + "'");
        } catch (IOException ex) {
            System.out.println("Error reading file '" + fileName + "'");
            // Or we could just do this:
            // ex.printStackTrace();
        }
    }

    // #region Method for Adding Quotes To the file
    static void AddQuotesToFile(String filename, String data) {
        QuoteFile myQuoteFile = new QuoteFile(data, filename);
        myQuoteFile.addEntry();
    }

    // #endregion
    static void retrieveQuote(int num) {

        QuoteFile myQuoteFile = new QuoteFile();
        String getQuote = myQuoteFile.retrieveQuote(num);
        System.out.println("\n");
        System.out.println("Quote is : " + getQuote);
    }

    // Write your aux methods here:
}