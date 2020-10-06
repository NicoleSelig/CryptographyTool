import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Substitution Class
 * @author Nicole Selig
 * handles all functions concerning the Substitution Cipher
 */

public class Substitution {
    
    //class variables
    Menu menu = new Menu();
    Utils utils = new Utils();
    Character[] alphabet = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r',
            's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };
    List<Character> alphaList = Arrays.asList(alphabet);

    /**
     * init()
     * initiates the Substitution cipher process
     * determins encryption or decryption
     */
    public void init() {
        System.out.println("Substitution Cipher");
        String filepath = utils.getFilePath();
        String text = utils.getMessageFromFile(filepath);

        String cryptChoice = menu.initCryptMenu();

        String key = utils.getStringKey();

        String[] keyArray = key.split("(?!^)");

        switch (cryptChoice) {
            case "e":
            case "E":
                String encryption = encrypt(text, keyArray);
                System.out.println(encryption);
                break;
            case "d":
            case "D":
                String decryption = decrypt(text, keyArray);
                System.out.println(decryption);
                break;
            default:
                System.out.println("Error with Substitution Initialization");
        }
    }

    /**
     * encrypt()
     * @param m
     * @param keyArray
     * @return String
     * encrypts the message
     */
    private String encrypt(final String m, String[] keyArray) {
        System.out.println("Encrypting " + m);
        String answer = "";
        List<Character> cipherAlphabet = getNewAlphabet(alphabet, keyArray);

        for (int i = 0; i < m.length(); i++)
            answer = answer + substitute(m.charAt(i), alphaList, cipherAlphabet);

        return answer;
    }

    /**
     * decrypt()
     * @param m
     * @param keyArray
     * @return String
     * decrypts the message
     */
    private String decrypt(final String m, final String[] keyArray) {
        LetterFrequency lf = new LetterFrequency();
        
        lf.findFrequencies(m);

        System.out.println("Decrypting " + m);
        String answer = "";
        List<Character> cipherAlphabet = getNewAlphabet(alphabet, keyArray);

        for (int i = 0; i < m.length(); i++)
            answer = answer + substitute(m.charAt(i), cipherAlphabet, alphaList);

        return answer;
    }

    /**
     * substitute()
     * @param c
     * @param oldAlpha
     * @param newAlpha
     * @return
     * helper function that substitutes a chararcter from an alphabet array.
     * the index of the old alphabet = the index of the new alphabet
     */
     
    private char substitute(char c, List<Character> oldAlpha, List<Character> newAlpha)
    { 
        Character newCharacter = null;

        if('a'<=c && c<='z')
        {
            int index = oldAlpha.indexOf(c);
            newCharacter = newAlpha.get(index);
        }
        else if('A'<=c && c <='Z')
        {
            int index = oldAlpha.indexOf(Character.toLowerCase(c));
            newCharacter = Character.toUpperCase(newAlpha.get(index));
        }
        else
          newCharacter = c;

        return newCharacter;  
    }

    /**
     * getNewAlphabet()
     * @param alphabet
     * @param keyArray
     * @return ArrayList
     * private helper function that creates a new 'substitution' alphabet using a keyword.
     */
     
     private ArrayList<Character> getNewAlphabet(Character[] alphabet, String[] keyArray)
     {
         System.out.println("Creating new alphabet...");
         ArrayList<Character> alphaSub = new ArrayList<>();
 
         //convert the key to a list of strings
         List<String> keyList = Arrays.asList(keyArray);
 
         //set the key for the first part of the new alphabet
         for (int i = 0; i < keyArray.length; i++ )
         {
             alphaSub.add(keyArray[i].charAt(0));
         }

         //find the keywords last letter and its index
         String keywordLastLetter = keyArray[keyArray.length-1];
         int keywordLastLetterIndex = alphaList.indexOf(keywordLastLetter.charAt(0));
      
         //set the rest of the alphabet
         //if the letter in the alphabet does not exist in the key, insert it into the substitution alphabet
         for (int i = keywordLastLetterIndex + 1; i < alphabet.length; i++)
         {
             Boolean doesNotExist = !keyList.contains(alphaList.get(i).toString());
             if(doesNotExist)
             {
                 alphaSub.add(alphabet[i]);
             }  
         }
         for(int i = 0; i < keywordLastLetterIndex; i++){
            Boolean doesNotExist = !keyList.contains(alphaList.get(i).toString());
             if(doesNotExist)
             {
                alphaSub.add(alphabet[i]);
             }
         }
         //System.out.println("alphaSub = " + alphaSub);
         return alphaSub;
     }
}
