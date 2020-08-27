
public class Menu {

    String [] menuItems = {"Ceasar Cypher -- C", "Substitution Cypher -- S", "Quit - Q"};
   
    //presents the Cipher Menu
    public void initCipherMenu(){
        System.out.println("Which Cypher did you want to use?");
        System.out.println("");

        for (int i = 0; i <= menuItems.length - 1; i++){
            System.out.println(menuItems[i]);
        }
    }

    //Recieves user's menu choice and picks a Cipher
    public void chooseCipher(String menuItem) {
        switch(menuItem) {
            case "c":
            case "C":
                System.out.println("Ceasar Cipher");
                break;
            case "s":
            case "S":
                System.out.println("Substitution Cipher");
                break;
            case "q":
            case "Q":
                System.out.println("Quit");
                break;
            default:
                System.out.println("Invalid Choice. Try Again");
        }  
    }
}