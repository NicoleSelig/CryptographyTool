
import java.util.Map;

public class Veginere {
    Menu menu = new Menu();
    Utils utils = new Utils();

    public void init() {
        System.out.println("Veginere Cipher");
        String filepath = utils.getFilePathFromFile();
        String text = utils.getMessageFromFile(filepath);

        String cryptChoice = menu.initCryptMenu();

        switch (cryptChoice) {
            case "e":
            case "E":
                // String encryption = encrypt(text, key);
                System.out.println("encryption");
                break;
            case "d":
            case "D":
                // String decryption = decrypt(text, key);
                System.out.println("decryption");
                decrypt(text);
                break;
            default:
                System.out.println("Error with Ceasar Initialization");
        }
    }

    public void decrypt(String m) {
        System.out.println("Decrypting " + m);
        LetterFrequency lf = new LetterFrequency();

        Map<Character, Integer> letterCount = lf.countLetters(m);
        System.out.println(letterCount.toString());

        Map<Character, Double> frequencies = lf.getLetterFrequencyMap();
        System.out.println(frequencies.toString());
    }
}