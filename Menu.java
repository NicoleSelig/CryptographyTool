import java.util.*;

public class Menu {

    String [] cipherMenuItems = {"Ceasar Cypher -- C", "Substitution Cypher -- S", "Home  -- H", "Quit -- Q"};
    String [] cryptMenuItems = {"Encrypt -- E"," Decrypt -- D", "Home -- H", "Quit -- Q"};
    
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
        Scanner scan = new Scanner(System.in);
        String menuItem = scan.next();
        switch(menuItem) {
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
            case "q":
            case "Q":
                System.out.println("Quit");
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
    
    //recieves the users choice chooses a crypt
    public void chooseCrypt() {
        Scanner scan = new Scanner(System.in);
        String menuItem = scan.next();
        switch(menuItem) {
            case "e":
            case "E":
                System.out.println("Encrypt");
                scan.close();
                break;
            case "d":
            case "D":
                System.out.println("Decrypt");
                scan.close();
                break;
            case "q":
            case "Q":
                System.out.println("Quit");
                scan.close();
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
                chooseCrypt();
                break;
        }  
    }
}