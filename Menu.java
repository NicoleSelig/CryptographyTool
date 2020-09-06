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
        chooseCipher();
    }

    //presents the crypt menu
    public String initCryptMenu(){
        System.out.println("");
        System.out.println("Encryption or Decryption?");
        System.out.println("");

        for (int i = 0; i <= cryptMenuItems.length - 1; i++){
            System.out.println(cryptMenuItems[i]);
        }
        return chooseCrypt();
    }

    //Recieves user's menu choice and picks a Cipher
    public void chooseCipher() {
        Scanner scanCipher = new Scanner(System.in);
        String menuItem = scanCipher.next();
        switch (menuItem) {
            case "c":
            case "C":
                Ceasar ceasar = new Ceasar();
                ceasar.init();
                break;
            case "s":
            case "S":
                Substitution sub = new Substitution();
                sub.init();
                break;
            case "a":
            case "A":
                Affine affine = new Affine();
                affine.init();
                break;
            case "v":
            case "V":
                System.out.println("Vigenere Cipher");
                initCryptMenu();
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
                break;
            default:
                System.out.println("Invalid Choice. Try Again");
                chooseCipher();
                break;
        }
    }

    // recieves the users choice chooses a crypt
    public String chooseCrypt() {
        final Scanner scanCrypt = new Scanner(System.in);
        final String menuItem = scanCrypt.next();
        switch(menuItem) {
            case "e":
            case "E":
                System.out.println("choose Encrypt");
                return menuItem;
            case "d":
            case "D":
                System.out.println("choose Decrypt");
                return menuItem;
            case "q":
            case "Q":
                scanCrypt.close();
                System.out.println("Good Bye!");
                System.exit(0);
                return menuItem;
            case "h":
            case "H":
                initCipherMenu();
                return menuItem;
            default:
                System.out.println("Invalid Choice. Try Again");
                chooseCrypt();
                return menuItem;
        }  
    }
}