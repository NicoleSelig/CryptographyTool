import java.util.Scanner;

public class Ceasar {

    Menu menu = new Menu();
    Utils utils = new Utils();

    public void init(){
        String filepath = utils.getFilePath();
        String text = utils.getMessage(filepath);

        String crypt = menu.initCryptMenu();
        System.out.println("Decrypt or Crypt? " + crypt);

        Scanner scanKey = new Scanner(System.in);
        System.out.println("Enter your key (1-25)");
        
        int key;
        key = scanKey.nextInt();

        System.out.println("Key is " + key);
        
        switch(crypt){
            case "e":
            case "E":
                System.out.println("Entered Switch Encrypting");
                encrypt(text, key);
                break;
            case "d":
            case "D":
                decrypt(text);
                break;
            default:
                System.out.println("Error with Ceasar Initialization");
        }
    }

    private void encrypt(String message, int key) {
        System.out.println("Encrypting " + message);
        
        //code gets stuck here...infinite loop
        // for (int i = 0; i < message.length(); i++)
        //     message = message + shift(message.charAt(i), key);
        // System.out.println(message);
    }

    char shift(char c, int k)
    {
	  if('a'<=c && c<='z')
	  {
		  c=(char)((int)c+k);
		  if(c>'z') c=(char)((int)c-26);
	  }
	  if('A'<=c && c<='Z')
	  {
		  c=(char)((int)c+k);
		  if(c>'Z') c=(char)((int)c-26);
	  }
	  return c;
    }

    private void decrypt(String message) {
        System.out.println("Decrypting " + message);
    }
}