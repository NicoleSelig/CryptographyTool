import java.io.*;
import java.util.*;

public class Main {

public static void main(final String[] args) {
    CipherMenu cipherMenu = new CipherMenu();
    

    System.out.println("Cryptography Tool");
    System.out.println("By Nicole Selig");
    System.out.println("");

    cipherMenu.init();
    Scanner scan = new Scanner(System.in);
    String menuItem = scan.nextLine();
    scan.close();
    cipherMenu.choose(menuItem);
    
}

}






