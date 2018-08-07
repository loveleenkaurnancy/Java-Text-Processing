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
            return lines;
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
            bw.write(filedata);
            bw.newLine();
            bw.close();
            // Files.write(Paths.get(file), filedata.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //#endregion
    //#region Find nth line quote from file
    public String retrieveQuote(int num){
        try{
            num = num-1;
            String line = Files.readAllLines(Paths.get("favorite.txt")).get(num);
            return line;
        }catch(IOException e){
            e.printStackTrace();
            return "Something went wrong";
        }
        
    }
    //#endregion
}
