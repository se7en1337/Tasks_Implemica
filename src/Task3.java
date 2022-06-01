import java.math.BigInteger;
/**
 * This class implements finding the factorial
 * of the number 100 and the sum of its digits.
 * @author Oleg Leonov
 */
public class Task3 {
    public static void main(String[] args)
    {
        // Variable initialization

        BigInteger fact = new BigInteger("2");
        char c;
        int result=0;

        // Finding the factorial

        for(int i = 3;i < 100;i+=1)
        {
            fact = fact.multiply(BigInteger.valueOf(i));
        }

        String str = fact.toString();

        // Finding the sum of the factorial digits

        for(int i = 0;i<str.length();i+=1)
        {
            c = str.charAt(i);
            result += Character.getNumericValue(c);
        }

        System.out.println(String.format("Factorial = %s \nResult = %s",fact,result) );
    }
}