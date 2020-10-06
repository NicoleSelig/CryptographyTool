import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * Utils Class
 * @author Nicole Selig
 * handles all miscellaneous functions
 */
public class Utils {

    /**
     * getFilePathFromFile()
     * @return String
     * gets the desired file path from the user
     */

    public String getFilePath(){
        Scanner inputScan = new Scanner(System.in);
        System.out.println("What is the filename you want to analyze?");
        final String filePath = inputScan.nextLine();
        System.out.println("filepath: " + filePath);
        
        return filePath;  
    }

    /**
     * getMessageFromFile()
     * @param filePath
     * @return String
     * gets the message from the file and returns as a string
     */
    public String getMessageFromFile(String filePath)
    {
        String message = "";
        try {
            File file = new File(filePath);
            //System.out.println("file exist? " + file.exists());
            if (file.exists()){
            Scanner cin = new Scanner(file);
            while (cin.hasNextLine()){
                message = message + "" + cin.nextLine();
            }
            }
            else {
                System.out.println("That file does not exist! Try again");
                Scanner input = new Scanner(System.in);
                filePath = input.nextLine();
                getMessageFromFile(filePath);
                
            }
        
        } catch (FileNotFoundException e) {
            System.out.println("getMessage: Error Getting the message from file");
            e.printStackTrace();
            e.getCause();
            System.exit(1);
        }
        return message;
    }

    /**
     * getIntKey();
     * @return int
     * gets an integer key value from a user
     */
    public int getIntKey()
    {
        Scanner scanKey = new Scanner(System.in);
        System.out.println("Enter your key (1-25)");
        
        int key;
        key = scanKey.nextInt();

        System.out.println("Key is " + key);
        
        return key;
    }   

    /**getKeyGuess
     * @return int
     * gets the users keyword length guess for veginere cipher
     */
    public int getKeyGuess()
    {
        Scanner scanKey = new Scanner(System.in);
        System.out.println("Guess the Keyword Length: ");
        
        int key;
        key = scanKey.nextInt();

        System.out.println("Key is " + key);
       
        
        return key;
    }

    /**
     * getStringKey()
     * @return String
     * gets a string value key from the user
     */
    public String getStringKey()
    {
        Scanner scanKey = new Scanner(System.in);
        System.out.println("Enter your keyword: ");
        
        String key;
        key = scanKey.next();
        System.out.println("Key is " + key);
        
        return key;
    }

    /**
     * getA
     * @return int
     * gets the constant value from the user for Affine
     */
    public int getA()
    {
        Scanner scanConstant = new Scanner(System.in);
        System.out.println("Enter your constant: ");
        int constant = scanConstant.nextInt();
        System.out.println("Constant is " + constant);
        return constant;
    }
    
    /**
     * fixString()
     * @param str
     * @return String
     * removes all spaces and punctuation from a string
     */
    public String fixString(String str)
    {
        str.replaceAll(" ", "");
        str.replaceAll("\\p{Punct}", "");
        return str;
    }

    /**
     * getIndexOfLargest()
     * @param array
     * @return int
     * gets the index of the largest value in an array
     */
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


    /**
     * everyNth()
     * @param str
     * @param numStart
     * @param k
     * @return String
     * scans a string for every nth letter and returns as another string
     */
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
