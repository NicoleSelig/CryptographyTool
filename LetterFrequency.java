import java.util.HashMap;

public class LetterFrequency {


    HashMap<Character, Double> lf = new HashMap<Character,Double>();
    public void initLetterFreqMap(){
        lf.put('e', 12.702);
        lf.put('t', 9.056);
        lf.put('a', 8.167);
        lf.put('o', 7.507);
        lf.put('i', 6.966);
        lf.put('n', 6.749);
        lf.put('s', 6.327);
        lf.put('h', 6.094);
        lf.put('r', 5.987);
        lf.put('d', 4.253);
        lf.put('l', 4.025);
        lf.put('c', 2.782);
        lf.put('u', 2.758);
        lf.put('m', 2.406);
        lf.put('w', 2.360);
        lf.put('f', 2.228);
        lf.put('g', 2.015);
        lf.put('y', 1.974);
        lf.put('p', 1.929);
        lf.put('b', 1.492);
        lf.put('v', 0.978);
        lf.put('k', 0.772);
        lf.put('j', 0.153);
        lf.put('x', 0.150);
        lf.put('q', 0.095);
        lf.put('z', 0.074);
    }

    public void printLFMap(){
        System.out.println(lf.toString());
    }

    public double dotProduct(double [] a, double []b)
    {
        double sum = 0;
        for(int i =0; i < 26; i++)
            sum+=a[i]*b[i];
        return sum;
    }

    public void countLetters(String m)
    {
        //remove spaces from text and convert all to lowercase
       String lcm = m.replaceAll(" ", "").toLowerCase();
       System.out.println(lcm);

       HashMap<Character, Integer> charCount = new HashMap<Character, Integer>();

       //convert the string to a char array
       char[] text = lcm.toCharArray();

       //check each char of the array
       for (char c : text) 
       {
           if (charCount.containsKey(c))
           {
               charCount.put(c, charCount.get(c)+1);
           }
           else
           {
                charCount.put(c,1);
           }
       }

       System.out.println(charCount.toString());
    } 

    public void shift(double [] a)
    {
        double temp = a[0];
        for(int i = 0; i < 25; i++)
            a[i] = a[i +1];
        a[25] = temp;
    }



}
