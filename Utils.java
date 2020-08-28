import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

public class Utils {

    public String getFilePath(){
        final Scanner inputScan = new Scanner(System.in);
        System.out.println("What is the filename you want to analyze?");
        final String filePath = inputScan.nextLine();
        return filePath;
    }

    public String getMessage(String filePath){
    
        String message = "";
        try {
            File file = new File(filePath);
            Scanner cin = new Scanner(file);
            while (cin.hasNextLine()){
                message = message + "" + cin.nextLine();
            }
            cin.close();
        } catch (FileNotFoundException e) {
            System.out.println("getMessage: Error Getting the message from file");
            e.printStackTrace();
        }
        return message;
    }

}
