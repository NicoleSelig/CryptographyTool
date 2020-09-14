public class Calculations {

    public double dotProduct(double [] a, double []b)
    {
        double sum = 0;
        for(int i =0; i < 26; i++)
            sum+=a[i]*b[i];
        return sum;
    }
}