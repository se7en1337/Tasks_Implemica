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

        Scanner scn = new Scanner(System.in);
        System.out.println("Enter number");

        // Variable initialization

        int n = scn.nextInt();
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
                        for (int j = 0; j < l.size(); j++) {
                            result += l.get(j) * l.get(l.size() - 1 - j);
                        }
                        l.add(result);
                    }
                }
            }
        System.out.println(String.format("Correct bracket expressions - %s", l.get(l.size()-2)));
    }
}
