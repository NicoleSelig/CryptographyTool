import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Substitution {
    Menu menu = new Menu();
    Utils utils = new Utils();
    Character[] alphabet = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
    List<Character> alphaList = Arrays.asList(alphabet);

    public void init(){
        System.out.println("Substitution Cipher");
        final String filepath = utils.getFilePathFromFile();
        final String text = utils.getMessageFromFile(filepath);

        final String cryptChoice = menu.initCryptMenu();

        final String key = utils.getStringKey();
        
        final String [] keyArray = key.split("(?!^)");
        
      
        switch(cryptChoice){
            case "e":
            case "E":
                final String encryption = encrypt(text, keyArray);
                System.out.println(encryption);
                break;
            case "d":
            case "D":
                final String decryption = decrypt(text, keyArray);
                System.out.println(decryption);
                break;
            default:
                System.out.println("Error with Substitution Initialization");
        }
    }

    private String encrypt(final String  m, String[] keyArray) {
        System.out.println("Encrypting " + m); 
        String answer = "";
        final List<Character> cipherAlphabet = getNewAlphabet(alphabet,keyArray);
        System.out.println(cipherAlphabet);
        System.out.println(alphaList);

        for (int i = 0; i < m.length(); i++)
            answer = answer + substitute(m.charAt(i), alphaList, cipherAlphabet);

        return answer;
    }

    private String decrypt(final String m, final String[] keyArray) {
        System.out.println("Decrypting " + m);
    
        String answer = "";
        List<Character> cipherAlphabet = getNewAlphabet(alphabet, keyArray);
        System.out.println(cipherAlphabet);
        System.out.println(alphaList);

        for (int i = 0; i < m.length(); i++)
            answer = answer + substitute(m.charAt(i), cipherAlphabet, alphaList);

        return answer;
    }

     //helper function that substitutes a chararcter from an alphabet array.
    //the index of the old alphabet = the index of the new alphabet
    private char substitute(char c, List<Character> oldAlpha, List<Character> newAlpha)
    { 
        Character newCharacter = null;
        //System.out.println("character: " + c);
        if('a'<=c && c<='z')
        {
            int index = oldAlpha.indexOf(c);
            //System.out.println("index " + index);
            newCharacter = newAlpha.get(index);
        }
        else if('A'<=c && c <='Z')
        {
            //System.out.println("character: " + c);
            int index = oldAlpha.indexOf(Character.toLowerCase(c));
            //System.out.println("index " + index);
            newCharacter = Character.toUpperCase(newAlpha.get(index));
        }
        else
          newCharacter = c;
        //System.out.println("newCharacter: " + newCharacter);
        return newCharacter;  
    }

     //private helper function that creates a new 'substitution' alphabet using a keyword.
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
      
         //set the rest of the alphabet
         //if the letter in the alphabet does not exist in the key, insert it into the substitution alphabet
         for (int i = 0; i < alphabet.length; i++)
         {
             //System.out.println(alphaList.get(i));
             Boolean doesNotexist = !keyList.contains(alphaList.get(i).toString());
            // System.out.println(doesNotexist);
             if(doesNotexist)
             {
                 alphaSub.add(alphabet[i]);
             }  
         }
         return alphaSub;
     }
}
