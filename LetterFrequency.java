import java.util.*;
import java.util.Map.Entry;
public class LetterFrequency {

    public Map<Character, Double> getEnglishFrequencyMap(){
        HashMap<Character, Double> lf = new HashMap<Character,Double>();
        lf.put('e', .12702);
        lf.put('t', .09056);
        lf.put('a', .08167);
        lf.put('o', .07507);
        lf.put('i', .06966);
        lf.put('n', .06749);
        lf.put('s', .06327);
        lf.put('h', .06094);
        lf.put('r', .0987);
        lf.put('d', .04253);
        lf.put('l', .04025);
        lf.put('c', .02782);
        lf.put('u', .02758);
        lf.put('m', .02406);
        lf.put('w', .02360);
        lf.put('f', .02228);
        lf.put('g', .02015);
        lf.put('y', .01974);
        lf.put('p', .01929);
        lf.put('b', .01492);
        lf.put('v', .00978);
        lf.put('k', .00772);
        lf.put('j', .00153);
        lf.put('x', .00150);
        lf.put('q', .00095);
        lf.put('z', .00074);
        return lf;
    }

    public Double dotProduct(double[] frequencies, double[] frequencies2) {
        double sum = 0;
        for (int i = 0; i < 26; i++)
            sum += frequencies[i] * frequencies2[i];
        return sum;
    }

    public Map<Character, Double> countLetters(final String m) {
        // remove punctuation from text and convert all to lowercase
        String words = m.replaceAll("\\p{Punct}", "").toLowerCase();

        HashMap<Character, Double> charCount = new HashMap<Character, Double>();
        for (char ch = 'a'; ch <= 'z'; ch++){
            charCount.put(Character.valueOf(ch), 0.0);
        }

        // convert the string to a char array
        char[] text = words.toCharArray();

        // check each char of the array and increment in the hashmap
        for (char c : text) {
             if (charCount.containsKey(c) && c != ' ') {
                 charCount.put(c, charCount.getOrDefault(c,0.0) + 1);
             } else if (c != ' ') {
                 charCount.put(c, 1.0);
             }
         }
        return charCount; 
    }

    public double maxValue(double[] cosetFreq)
    {   
        double max = Arrays.stream(cosetFreq).max().getAsDouble();
        return max;
    }

    public double[] findFrequencies(String m)
    {
        m = m.replaceAll(" ", "");
        //System.out.println(m);
       //System.out.println("text length: " + m.length());

        Map<Character, Double> charCount = countLetters(m);
        Double[] counts =(Double[])charCount.values().toArray(new Double[charCount.size()]);

        double[] frequencies = new double[counts.length];
        //System.out.println("counts: " + Arrays.toString(counts));

        for(int i = 0; i < counts.length; i++){
            
            frequencies[i] = (Double) (counts[i] / m.length());
         
        }
        return frequencies;
    }

    public void shift(final double[] a) {
        final double temp = a[0];
    
        for(int i = 0; i < 25; i++)
            a[i] = a[i + 1];
        a[25] = temp;
    }

}
