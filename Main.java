import java.io.*;
import java.util.*;

public class Main {

public static void main(final String[] args) {
    Menu menu = new Menu();
    
    System.out.println("Cryptography Tool");
    System.out.println("By Nicole Selig");
    System.out.println("");

    menu.initCipherMenu();
    Scanner scan = new Scanner(System.in);
    String menuItem = scan.nextLine();
    scan.close();
    menu.chooseCipher(menuItem);
    
}

}






