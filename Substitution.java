import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Substitution {
    Menu menu = new Menu();
    Utils utils = new Utils();
    String[] alphabet = {"a","b","c","d","e","f","g","h","i","j","k","l","m","o","p","q","r","s","t","u","v","w","x","y","z"};

    public void init(){
        System.out.println("Substitution Cipher");
        String filepath = utils.getFilePathFromFile();
        String text = utils.getMessageFromFile(filepath);

        String cryptChoice = menu.initCryptMenu();

        String key = utils.getStringKey();
        
        String [] keyArray = key.split("(?!^)");
        
      
        switch(cryptChoice){
            case "e":
            case "E":
                String encryption = encrypt(text, keyArray);
                System.out.println(encryption);
                break;
            case "d":
            case "D":
                String decryption = decrypt(text);
                System.out.println(decryption);
                break;
            default:
                System.out.println("Error with Substitution Initialization");
        }
    }

    private String encrypt(String  m, String[] keyArray) {
        System.out.println("Encrypting " + m); 
        String answer = "";
        ArrayList<String> newAlphabet = getNewAlphabet(alphabet,keyArray);
        System.out.println(newAlphabet);
        return answer;
    }

    private ArrayList<String> getNewAlphabet(String[] alphabet, String[] keyArray)
    {
        System.out.println("Creating new alphabet...");
        ArrayList<String> alphaSub = new ArrayList<>();

        //convert the key to a list of strings
        List<String> keyList = Arrays.asList(keyArray);

        //set the key for the first part of the new alphabet
        for (int i = 0; i < keyArray.length; i++ )
        {
            alphaSub.add(keyArray[i]);
        }
        System.out.println(alphaSub);
     
        //set the rest of the alphabet
        //if the letter in the alphabet does not exist in the key, insert it into the substitution alphabet
        for (int i = 0; i < alphabet.length; i++)
        {
            Boolean doesNotexist = !keyList.contains(alphabet[i]);
            if(doesNotexist)
            {
                alphaSub.add(alphabet[i]);
            }
        }
        return alphaSub;
    }

    private String decrypt(String m) {
        return "Decrypting " + m;
    }


}
