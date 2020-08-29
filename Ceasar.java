public class Ceasar {

    Menu menu = new Menu();

    public void init(){
        String crypt = menu.initCryptMenu();
        System.out.println("Decrypt or Crypt? " + crypt);
    }
}