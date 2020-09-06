import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

public class Utils {

    public String getFilePathFromFile(){
        Scanner inputScan = new Scanner(System.in);
        System.out.println("What is the filename you want to analyze?");
        
        final String filePath = inputScan.nextLine();
        return filePath;  
    }

    public String getMessageFromFile(String filePath)
    {
    
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
        return constant;
    }


    public void updateFile (String filepath, String string) {
        System.out.println("Update File");
    }

    // public void printStringArray(ArrayList<String> alphaSub){
    //     String printed = "";
    //     for(int i=0; i < alphaSub.length; i++){
    //         printed += alphaSub[i];
    //     }
    //     System.out.println(printed);
    // }

}
