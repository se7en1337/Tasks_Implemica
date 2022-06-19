package com.implemica;

import java.math.BigInteger;
/**
 * This class implements finding the factorial
 * of the number 100 and the sum of its digits.
 * @author Oleg Leonov
 */
public class Task3 {
    public static void main(String[] args)
    {
        // We create a string in which there will be a factorial

        String str = factorial();

        // Output

        System.out.println(String.format("Factorial = %s \nResult = %s",factorial(),computing(str)) );
    }

    /**
     * Finding the sum of the factorial digits
     * @param s -  Factorial of number 100
     * @return the sum of the factorial digits
     */
    public static int computing(String s)
    {
        // Variable initialization

        char c;
        int result=0;

        // Finding the sum of the factorial digits

        for(int i = 0;i<s.length();i+=1)
        {
            c = s.charAt(i);
            result += Character.getNumericValue(c);
        }
        return result;
    }

    /**
     * Finding the factorial of number 100
     * @return factorial of 100 in string form
     */
    public static String factorial()
    {
        // Variable initialization

        BigInteger fact = new BigInteger("2");


        // Finding the factorial

        for(int i = 3;i < 100;i+=1)
        {
            fact = fact.multiply(BigInteger.valueOf(i));
        }
        return fact.toString();
    }
}