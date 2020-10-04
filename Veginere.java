import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;


public class Veginere {
    Menu menu = new Menu();
    Utils utils = new Utils();
    String[] alphabet = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s",
            "t", "u", "v", "w", "x", "y", "z" };
    LetterFrequency lf = new LetterFrequency();
    Map<Character, Double> englishMap = lf.getEnglishFrequencyMap();
    String alphaString = "abcdefghijklmnopqrstuvwxyz";
    int shift = 4;
    int keyGuess;
    String keyword;

    public void init() {
        System.out.println("Veginere Cipher");
        String filepath = utils.getFilePathFromFile();
        String text = utils.getMessageFromFile(filepath);
        String cryptChoice = menu.initCryptMenu();

        switch (cryptChoice) {
            case "e":
            case "E":
                String encryption = encrypt(text, keyword);
                System.out.println(encryption);
                break;
            case "d":
            case "D":
                // String decryption = decrypt(text, key);
                System.out.println("decryption");
                boolean notDone = true;
                while (notDone){
                    decrypt(text);
                    System.out.println("Did your guess give you the right key?\n No, Guess Again -- N \n Yes, I have plaintext! -- Y");
                    Scanner in = new Scanner(System.in);
                    String input = in.next();
                    System.out.println(input);
                    switch(input){
                        case "y":
                        case "Y":
                            notDone = false;
                            break;
                        case "N":
                        case "n":
                            notDone = true;
                        default:
                            System.out.println("Wrong Input. Try Again");
                    }
                    in.close();
                }
                break;
            default:
                System.out.println("Error with Ceasar Initialization");
        }
    }

    String encrypt(String m, String key) {
        //prep the strings
        String [] mArr = m.split("(?!^)");
        String[] keyArr = key.split("(?!^)");

        //convert the plaintext to index representation
        int [] mIndeces = convertToIndeces(mArr, mArr.length);

        //convert the key to indeces and repeat them across the length of the plaintext
        int [] keyIndeces = convertToIndeces(keyArr, keyArr.length);
        int [] cipherArr = repeat(keyIndeces, mArr.length);
        
        int [] cipherTextIndeces = getNewIndices(mIndeces, cipherArr);

        String [] cipherText = getTextFromIndeces(cipherTextIndeces);
        
        return "Cipher Text: \n" + Arrays.toString(cipherText);

    }

    void decrypt(String m) {
        
        //System.out.println("Decrypting " + m);

        //prepare the string
        String text = m.replaceAll(" ", "");
    
        //get the frequencies of letters in the string
        double[] frequencies = lf.findFrequencies(m);

        //find the index of coincidence
        double indexOfCoincidence = lf.dotProduct(frequencies, frequencies);
        
        //give an estimate length of key, but ask the user to make their own guess
        //the estimate can be off by several letters
        int ApproxKeyLength = estimateKeywordLength(indexOfCoincidence, m.length());
        System.out.println("The Approximate keyword length is: " + ApproxKeyLength + "\nBut this approximation may be off by a few letters\n");
        keyGuess = utils.getKeyGuess();


        String[] keywordArr = new String[keyGuess];
        String coset= ""; 
        for (int i = 0; i < keyGuess; i ++){
            
            //find a coset shift of every nth letter
            coset = utils.everyNth(text, i, keyGuess);
            
            //find the coset and english frequencies
            double[] cosetFreq = lf.findFrequencies(coset);
            Object[] ef = englishMap.values().toArray();
            double[] englishFreq = Arrays.stream(ef).mapToDouble(num -> Double.parseDouble(num.toString())).toArray();
        
            //find the dot product of the two frequencies for each coset shift
            double [] dotProductArr = new double[26];
            for(int shiftAmt = 0; shiftAmt < 26; shiftAmt++)
            {
                dotProductArr[shiftAmt] = lf.dotProduct(cosetFreq, englishFreq);
                lf.shift(englishFreq);
            }
            
            //the max shift is the index of the largest dot product
            int maxShift = utils.getIndexOfLargest(dotProductArr);

            //use the max shift to find the letter 
            int neededindex = 26 - maxShift;
            //System.out.println(maxShift + " : " + alphabet[neededindex]);

            //add the letter to the keyword
            keywordArr[i] = alphabet[neededindex];
            
        }

        //reveal the keyword
        StringBuilder keyword = new StringBuilder();
        for(String s : keywordArr) {
            keyword.append(s);
        }
        String keywordStr = keyword.toString();
        System.out.println("The Keyword is: " + keywordStr);

        //convert the keyword to an array of indeces
        int[] keywordIndeces = convertToIndeces(keywordArr, keywordArr.length);
        int[] cipherTextIndeces = convertToIndeces(text.toLowerCase().split(""), text.length());
        // System.out.println(Arrays.toString(cipherTextIndeces));
        // System.out.println(Arrays.toString(keywordIndeces));

        //repeat them across the length of the message
        int[] keyIndecesRepeated = repeat(keywordIndeces, text.length());
        // System.out.println(Arrays.toString(keyIndecesRepeated));

        //TRANSLATE
        int[] plainTextIndeces = getNewIndices(cipherTextIndeces, keyIndecesRepeated);
       
        // System.out.println(Arrays.toString(plainTextIndeces));
        String [] plainText = getTextFromIndeces(plainTextIndeces);
        System.out.println(Arrays.toString(plainText));
     }


    String[] getTextFromIndeces(int[] arr) {
        String[] plainText = new String[arr.length];
        for (int i = 0; i < arr.length; i++)
        {
            plainText[i]= alphabet[arr[i]];
        }
        return plainText;
    }

    int[] getNewIndices(int[] cipher_text, int[] key) 
        { 
            for(int i = 0; i < cipher_text.length; i++)
            {
                cipher_text[i] = (cipher_text[i]-key[i] + 26) % 26;
            }
            
            return cipher_text;
        } 

     int[] convertToIndeces(String [] arr, int length) {
        int[] arrOfIndeces = new int[length];
            for(int i=0; i<length; i++)
            {
                arrOfIndeces[i]= Arrays.binarySearch(alphabet, arr[i]);
            }
            return arrOfIndeces;
    }

     int[] convertCharToIndeces(char [] arr, int length) {
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
 
 

   
     

    
}