package com.implemica;
import java.util.InputMismatchException;
import java.util.Scanner;
/**
 * This program searches for the shortest
 * path using Dijkstra's algorithm.
 * @author Oleg Leonov
 */
public class Task2 {
    public static void main(String[] args) {
        // Variable initialization
        int tests=0;
        Scanner scan = new Scanner(System.in);

        do {
            while (true) {
                try {
                    System.out.print("How many times you want to use program? From 1 to 10 ");
                    if (scan.hasNext()) {
                        tests = scan.nextInt();
                    }
                    break;
                } catch (InputMismatchException ex) {
                    scan.nextLine();
                }
            }
        }while(tests>10);


        for(int z=0;z<tests;z++)
        {
            int size=0;
            do {
                while (true) {
                    try {
                        System.out.print("Enter number of cities (1 - 10 000) : ");
                        if (scan.hasNext()) {
                            size = scan.nextInt();
                        }
                        break;
                    } catch (InputMismatchException ex) {
                        scan.nextLine();
                    }
                }
            }while (size>10000);

            String name[] = new String[size]; // Names of the cities
            int way[][] = new int[size][size]; // link matrix
            int shortway[] = new int[size]; // minimum distance
            int visitcities[] = new int [size]; // peaks visited

            int temp=0,minindex,min;
            int findex=0;

            scan.nextLine();
            // Write down the names of the cities
            for(int i=0;i<size;i++)
            {
                System.out.print("Enter name of the city number" + (i+1) + " : ");
                name[i] = scan.nextLine();
            }
            // Link matrix initialization
            for(int i=0;i<size;i++)
            {
                way[i][i] = 0;
                for(int j = i+1;j<size;j++)
                {
                    while (true) {
                        try {
                            System.out.printf("Enter distance %s - %s", name[i] , name[j] + " : ");
                            if (scan.hasNext()) {
                                temp = scan.nextInt();
                            }
                            break;
                        } catch (InputMismatchException ex) {
                            scan.nextLine();
                        }
                    }



                    way[i][j] = temp;
                    way[j][i] = temp;
                }
            }
            // //Initialize vertices and distances
            for(int i =0;i<size;i++)
            {
                shortway[i] = 10000;
                visitcities[i] =1;
            }

            shortway[findex] = 0;
            // Solution algorithm
            do
            {
                minindex = 10000;
                min = 10000;
                for(int i=0;i<size;i++)
                {
                    // If the vertex has not yet been bypassed and the weight is less than min
                    if((visitcities[i]==1) && (shortway[i]<min))
                    {
                        min = shortway[i];
                        minindex = i;
                    }
                }
                // Add the found minimum weight
                // to the current vertex weight
                // and compare with the current minimum vertex weight
                if(minindex != 10000)
                {
                    for(int i=0;i<size;i++)
                    {
                        if(way[minindex][i] > 0)
                        {
                            temp = min + way[minindex][i];
                            if(temp<shortway[i])
                            {
                                shortway[i]=temp;
                            }
                        }
                    }
                    visitcities[minindex] = 0;
                }
            }while (minindex<10000);
            // Display the shortest distances to the vertices
            System.out.println("Shortest distances to cities :");
            for(int i=0;i<size;i++)
            {
                System.out.printf("%5d ",shortway[i]);
            }

            int[] vcities = new int[size]; // list of visited cities
            int end = size-2; // index of the last city
            vcities[0] = end +1;
            int lastcity=1; // past city index
            int cost = shortway[end]; // Path cost

            while (end != findex) // until we reach the starting city
                for(int i = 0;i<size;i++)
                {
                    if(way[i][end] !=0) // if there is a connection
                    {
                        int stemp = cost - way[i][end];
                        if(stemp==shortway[i]) // if the weight matches the calculated one
                        {                      // it means that there was a transition from this vertex
                            cost = stemp;
                            end=i;
                            vcities[lastcity] = i+1;
                            lastcity++;
                        }
                    }
                }

            System.out.println("\nShortest path");
            for(int i = 0;i<=lastcity-2;i++)
            {
                System.out.printf("%5s ",vcities[i]);
            }
    }
    }
}
