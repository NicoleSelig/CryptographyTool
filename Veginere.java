import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Veginere {
    Menu menu = new Menu();
    Utils utils = new Utils();
    String[] alphabet = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s",
            "t", "u", "v", "w", "x", "y", "z" };
    LetterFrequency lf = new LetterFrequency();
    Map<Character, Double> englishMap = lf.getEnglishFrequencyMap();
    String alphaString = "abcdefghijklmnopqrstuvwxyz";
    int shift = 4;

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
        
        // System.out.println("Decrypting " + m);
        String text = m.replaceAll(" ", "");
        //System.out.println("Fixed text: " + text);

        int keyGuess = 5;
        double[] frequencies = lf.findFrequencies(m);
        //System.out.println("cipher text fequencies: \n" + Arrays.toString(frequencies));

        double indexOfCoincidence = lf.dotProduct(frequencies, frequencies);
        //System.out.println("Index of Coincidence of cipher text: \n" + indexOfCoincidence);
        int ApproxKeyLength = estimateKeywordLength(indexOfCoincidence, m.length());
        System.out.println("Approx keylength of cipher text: \n" + ApproxKeyLength);
        String[] keywordArr = new String[keyGuess];
        String coset= ""; 
        for (int i = 0; i < keyGuess; i ++){
            coset = everyNth(text, i, keyGuess);
            System.out.println("Coset " + i + ": \n" + coset);
            double[] cosetFreq = lf.findFrequencies(coset);
            Object[] ef = englishMap.values().toArray();
            double[] englishFreq = Arrays.stream(ef).mapToDouble(num -> Double.parseDouble(num.toString())).toArray();
            Map<Character, Double> letterCount = lf.countLetters(coset);
            //System.out.println("coset letter count: \n" + letterCount.toString());
            //System.out.println("Coset & english dot product:");
            double [] dotProductArr = new double[26];

            for(int shiftAmt = 0; shiftAmt < 26; shiftAmt++)
            {
                //System.out.println("Shift: " + shiftAmt + " dotProduct: " + lf.dotProduct(cosetFreq, englishFreq));
                dotProductArr[shiftAmt] = lf.dotProduct(cosetFreq, englishFreq);
                // shiftMap.put(shiftAmt, lf.dotProduct(cosetFreq, englishFreq));
                lf.shift(englishFreq);
            }

            //System.out.println(Arrays.toString(dotProductArr));
            double maxDot = lf.maxValue(cosetFreq);
            System.out.println("max Dot: " + maxDot);
            int maxShift = getIndexOfLargest(dotProductArr);
            int neededindex = 26 - maxShift;
            System.out.println(maxShift + " : " + alphabet[neededindex]);
            
            keywordArr[i] = alphabet[neededindex];
            
        }

        StringBuilder keyword = new StringBuilder();
        for(String s : keywordArr) {
            keyword.append(s);
        }
        String keywordStr = keyword.toString();
        
        System.out.println(keywordStr);

        int[] keywordIndeces = convertToIndeces(keywordArr, keywordArr.length);
        int[] cipherTextIndeces = convertToIndeces(text.toLowerCase().split(""), text.length());
        System.out.println(Arrays.toString(cipherTextIndeces));
        // System.out.println(Arrays.toString(keywordIndeces));

        int[] keyIndecesRepeated = repeat(keywordIndeces, text.length());
        
        System.out.println(Arrays.toString(keyIndecesRepeated));

        int[] plainTextIndeces = getPlainTextIndices(cipherTextIndeces, keyIndecesRepeated);
        System.out.println("pain text indeces");
        System.out.println(Arrays.toString(plainTextIndeces));
        String [] plainText = getplainText(plainTextIndeces);

        System.out.println(Arrays.toString(plainText));
     }

    String[] getplainText(int[] arr) {
        String[] plainText = new String[arr.length];
        for (int i = 0; i < arr.length; i++)
        {
            plainText[i]= alphabet[arr[i]];
        }
        return plainText;
    }

    int[] getPlainTextIndices(int[] cipher_text, int[] key) 
        { 
            for(int i = 0; i < cipher_text.length; i++)
            {
                cipher_text[i] = (cipher_text[i]-key[i] + 26) % 26;
            }
            
            return cipher_text;
        } 

     public int[] convertToIndeces(String [] arr, int length) {
     int[] arrOfIndeces = new int[length];
        for(int i=0; i<length; i++)
        {
            arrOfIndeces[i]= Arrays.binarySearch(alphabet, arr[i]);
        }
        return arrOfIndeces;
    }

     int estimateKeywordLength(double indexOfCoincidence, int textsize) {
        double keylength = (0.0265*textsize)/((indexOfCoincidence*textsize-1) + 0.0656 - (0.0385*textsize));
        return (int) Math.ceil(keylength);
     }

     public <Integer> int[] repeat(int[] arr, int newLength) {
        int[] dup = Arrays.copyOf(arr, newLength);
        for (int last = arr.length; last != 0 && last < newLength; last <<= 1) {
            System.arraycopy(dup, 0, dup, last, Math.min(last << 1, newLength) - last);
        }
        return dup;
    }
 
     String everyNth(String str, int numStart, int k)
     {
         String coset = "";
         for (int i = numStart; i < str.length(); i+=k)
         {
            
                coset += str.charAt(i);
            
         }
         return coset;
     }

     public int getIndexOfLargest(double[] array )
    {
    if ( array == null || array.length == 0 ) return -1; // null or empty

    int largest = 0;
    for ( int i = 1; i < array.length; i++ )
    {
        if ( array[i] > array[largest] ) largest = i;
    }
    return largest; // position of the first largest found
    }
     

    
}