import java.util.*;

public class Menu {

    String [] cipherMenuItems = {"Ceasar Cipher -- C", "Substitution Cipher -- S", "Affine Cipher -- A", "Vigenere Cipher -- V" ,"Home  -- H", "Quit -- Q"};
    String [] cryptMenuItems = {"Encrypt -- E","Decrypt -- D", "Home -- H", "Quit -- Q"};
    
    //presents the Cipher Menu
    public void initCipherMenu(){
        System.out.println("");
        System.out.println("Which Cypher did you want to use?");
        System.out.println("");

        for (int i = 0; i <= cipherMenuItems.length - 1; i++){
            System.out.println(cipherMenuItems[i]);
        }
    }

    //presents the crypt menu
    public void initCryptMenu(){
        System.out.println("");
        System.out.println("Encryption or Decryption?");
        System.out.println("");

        for (int i = 0; i <= cryptMenuItems.length - 1; i++){
            System.out.println(cryptMenuItems[i]);
        }
    }

    //Recieves user's menu choice and picks a Cipher
    public void chooseCipher() {
        Scanner scanCipher = new Scanner(System.in);
        String menuItem = scanCipher.next();
        switch (menuItem) {
            case "c":
            case "C":
                System.out.println("Ceasar Cipher");
                initCryptMenu();
                chooseCrypt();
                break;
            case "s":
            case "S":
                System.out.println("Substitution Cipher");
                initCryptMenu();
                chooseCrypt();
                break;
            case "a":
            case "A":
                System.out.println("Affine Cipher");
                initCryptMenu();
                chooseCrypt();
                break;
            case "v":
            case "V":
                System.out.println("Vigenere Cipher");
                initCryptMenu();
                chooseCrypt();
                break;
            case "q":
            case "Q":
                System.out.println("Quit");
                scanCipher.close();
                System.out.println("Good Bye!");
                System.exit(0);
                break;
            case "h":
            case "H":
                System.out.println("Home");
                initCipherMenu();
                chooseCipher();
                break;
            default:
                System.out.println("Invalid Choice. Try Again");
                chooseCipher();
                break;
        }
    }

    // recieves the users choice chooses a crypt
    public void chooseCrypt() {
        final Scanner scanCrypt = new Scanner(System.in);
        final String menuItem = scanCrypt.next();
        switch(menuItem) {
            case "e":
            case "E":
                System.out.println("Encrypt");
                break;
            case "d":
            case "D":
                System.out.println("Decrypt");
                break;
            case "q":
            case "Q":
                scanCrypt.close();
                System.exit(0);
                break;
            case "h":
            case "H":
                initCipherMenu();
                chooseCipher();
                break;
            default:
                System.out.println("Invalid Choice. Try Again");
                chooseCrypt();
                break;
        }  
    }
}