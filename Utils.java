import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

public class Utils {

    public String getFilePathFromFile(){
        Scanner inputScan = new Scanner(System.in);
        System.out.println("What is the filename you want to analyze?");
        final String filePath = inputScan.nextLine();
        System.out.println("filepath: " + filePath);
        
        return filePath;  
    }

    public String getMessageFromFile(String filePath)
    {
        String message = "";
        try {
            File file = new File(filePath);
            System.out.println("file exist? " + file.exists());
            Scanner cin = new Scanner(file);
            while (cin.hasNextLine()){
                message = message + "" + cin.nextLine();
            }
            cin.close();
        } catch (FileNotFoundException e) {
            System.out.println("getMessage: Error Getting the message from file");
            e.printStackTrace();
            e.getCause();
            System.exit(1);
        }
        return message;
    }

    public int getIntKey()
    {
        Scanner scanKey = new Scanner(System.in);
        System.out.println("Enter your key (1-25)");
        
        int key;
        key = scanKey.nextInt();

        System.out.println("Key is " + key);
        
        return key;
    }   

    public int getKeyGuess()
    {
        Scanner scanKey = new Scanner(System.in);
        System.out.println("Guess the Keyword Length: ");
        
        int key;
        key = scanKey.nextInt();

        System.out.println("Key is " + key);
        
        return key;
    }

    public String getStringKey()
    {
        Scanner scanKey = new Scanner(System.in);
        System.out.println("Enter your key: ");
        
        String key;
        key = scanKey.next();
        System.out.println("Key is " + key);
        
        return key;
    }

    public int getA()
    {
        Scanner scanConstant = new Scanner(System.in);
        System.out.println("Enter your constant: ");
        int constant = scanConstant.nextInt();
        System.out.println("Constant is " + constant);
        scanConstant.close();
        return constant;
    }
    
    public String fixString(String str)
    {
        str.replaceAll(" ", "");
        str.replaceAll("\\p{Punct}", "");
        return str;
    }

    public void updateFile (String filepath, String string) {
        System.out.println("Update File");
    }

    public int getIndexOfLargest(double[] array )
    {
    if ( array == null || array.length == 0 ) return -1; // null or empty

    int largest = 0;
    for ( int i = 1; i < array.length; i++ )
    {
        if ( array[i] > array[largest] ) largest = i;
    }
    return largest; // position of the first largest found
    }

    
    String everyNth(String str, int numStart, int k)
    {
        String coset = "";
        for (int i = numStart; i < str.length(); i+=k)
        {
           
               coset += str.charAt(i);
           
        }
        return coset;
    }

}
