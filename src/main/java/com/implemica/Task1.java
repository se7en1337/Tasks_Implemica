package com.implemica;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.ArrayList;

/**
 * This class implements a fairly common
 * a problem that leads to an example of solutions with
 * using Catalan numbers
 * @author Oleg Leonov
 */

public class Task1 {
    public static void main(String[] args) {
        // Variable initialization
        int n = 0;
        Scanner scan = new Scanner(System.in);
        do {
            while (true) {
                try {
                    System.out.print("Enter number from 1 to 19 : ");
                    if (scan.hasNext()) {
                        n = scan.nextInt();
                    }
                    break;
                } catch (InputMismatchException ex) {
                    scan.nextLine();
                }
            }
            System.out.println(String.format("Correct bracket expressions - %s", process(n)));
        }while (n > 19);
    }

    /**
     * Checking the value and computing
     * @param n - Entered number
     * @return result of computing
     */
    public static int process(int n) {
        int result = 0;
        ArrayList<Integer> l = new ArrayList<>();
        l.add(1);
        l.add(1);

        // Checking the value

        if(n > 0)
        {

            // Computing

            for(int i=0;i<n;i++)
            {
                result=0;
                {
                    for (int j = 0; j < l.size(); j++)
                    {
                        result += l.get(j) * l.get(l.size() - 1 - j);
                    }
                    l.add(result);
                }
            }
        }
        return l.get(l.size()-2);
    }
}

