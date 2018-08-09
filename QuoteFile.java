import java.io.*;
import java.nio.file.Paths;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
// load the classes that you need. 

public class QuoteFile {

    // #region Declaring Variable and passing it inside Constructor
    String file, filedata;
    QuoteFile() {}
    QuoteFile(String file_name) { file = file_name;}
    QuoteFile(String file_data, String file_name) { file = file_name; filedata = file_data;}
    // #endregion

    // #region Count Of Quotes In file
    public int countQuotes() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            int lines = 0;
            String line;
            while ((line = reader.readLine()) != null) {
                if (!line.isEmpty()) {
                    lines++;
                }
            }
            reader.close();
            return lines/2;
        } catch (IOException e) {
            e.printStackTrace();
            return 0;
        }
    }
    // #endregion

    //#region Adding new quotation entry to the bottom ofthe text file in the same format 
    public void addEntry() {
        try {
            FileWriter fw = new FileWriter(file, true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write("\r");
            bw.write(filedata);
            bw.newLine();
            bw.close();
            // Files.write(Paths.get(file), filedata.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //#endregionaddEntry

    //#region Adding new quotation entry to the bottom ofthe text file in the same format 
    public void addAuthor() {
        try {
            FileWriter fw = new FileWriter(file, true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write("-- "+filedata);
            bw.newLine();
            bw.close();
            // Files.write(Paths.get(file), filedata.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //#endregionaddEntry

    //#region Find nth line quote from file
    public String retrieveQuote(int num){
        try{
            num = (num-1)*3;
            String line = Files.readAllLines(Paths.get("files/quotes.txt")).get(num);
            Quote myQuote = new Quote(line);
            String quote = myQuote.getQuote();

            String authorLine = Files.readAllLines(Paths.get("files/quotes.txt")).get(num+1);
            Quote myAuthor = new Quote();
            String author = myAuthor.getCredit(authorLine);

            int count = myQuote.getWordCount();

            String random=myQuote.scramblerGame();


            System.out.println("Scrambled String\n" + random);

            Scanner input = new Scanner(System.in);
            System.out.println(" ");
            System.out.print("Enter right quote \n");
            String qu = input.nextLine();

            if(quote.equals(qu))
            {
                System.out.print("\nYES\n");    
            }
            else
            {
                System.out.print("\nNO\n\n");    
            }


            Quote q = new Quote(line);
            System.out.println(q.fillBlank());

            String missing = input.nextLine();
            if(missing.equals("is"))
            {
                System.out.println("Right Guess");
            }
            else
            {
                System.out.println("Wrong Guess");
            }


            System.out.println(q.tripleX());

            String missing1 = input.nextLine();

            if(missing1.equals("a"))
            {
                System.out.println("Right Guess");
            }
            else
            {
                System.out.println("Wrong Guess");
            }


            String doc = quote + "\n\nAuthor is " + author + "\n\nNumber of words in quotes are " + count;

            return doc;
        }catch(IOException e){
            e.printStackTrace();
            return "Something went wrong";
        }
        
    }
    //#endregion



    //#region Searching Word 
    public String quoteSearch(String search, int i) {

        try{
            i = (i-1)*3;
            String line = Files.readAllLines(Paths.get("files/quotes.txt")).get(i);
            int intIndex = line.indexOf(search);
            if(intIndex == - 1) {
                return " ";
            } else {
                 return line;
            }

        }catch(IOException e){
            e.printStackTrace();
            return "Something went wrong";
        }
       
    }
    //#endregionsearchword

    public String wordSearch(String search, int i)
    {
        try{
            i = (i-1)*3;
            
            String line = Files.readAllLines(Paths.get("files/dictionary.txt")).get(i);

            Quote q=new Quote();
            String line2= q.defineWords(line);
            String meaning = Files.readAllLines(Paths.get("files/dictionary.txt")).get(i+1);
            int intIndex = line.indexOf(search);
            if(intIndex == - 1) {
                return " ";
            } else {
                 return meaning;
            }

        }catch(IOException e){
            e.printStackTrace();
            return "Something went wrong";
        }

    }
}
