package com.implemica;

import java.io.*;
import java.util.*;

/**
 * This program is designed to search for the most
 * short cut, as well as for
 * calculation of the final cost
 * trips between cities.
 * @author Oleg Leonov
 */
final class quictest {
    
    // Initialize array and variables
    
    public static int[][] parse(String str) throws Exception {

        Scanner sc = new Scanner(str);

        int n = sc.nextInt();
        int arr[][]  = new int[n+1][n+1];
        for(int i = 0; i < arr.length; ++i){
            for(int j = 0; j < arr[i].length; ++j)
                arr[i][j] = Integer.MAX_VALUE;
        }

        int i, j, v;
        while(sc.hasNextInt()){
            i = sc.nextInt();
            j = sc.nextInt();
            v = sc.nextInt();
            arr[i][j] = arr[j][i] = v;
        }
        sc = null;
        return arr;
    }

    // Searching short path
    
    public static int[] find(int[][] m, int start, Vector<Integer> pars) throws Exception {
        int[] ds = new int[m.length];
        for(int i = 0; i < ds.length; ++i)
            ds[i] = Integer.MAX_VALUE;

        boolean[] visit = new boolean[m.length];
        pars.setSize(m.length);
        
        // Searching path
        
        ds[start] = 0;
        int sel;
        for(int i = 0; i < m.length; ++i){
            sel = -1;

            for(int j = 0; j < m[i].length; ++j)
            {
                if(!visit[j] && (sel == -1 || ds[j] < ds[sel]))
                    sel = j;
            }

            if(ds[sel] == Integer.MAX_VALUE)
                break;
            visit[sel] = true;

            for(int j = 0; j < m[sel].length; ++j)
            {
                if(m[sel][j] == Integer.MAX_VALUE)
                    continue;
                if((ds[sel] + m[sel][j]) < ds[j])
                {
                    ds[j] = ds[sel] + m[sel][j];
                    pars.set(j, sel);
                }
            }
        }

        visit = null;
        return ds;
    }

    // Show all path
    public static void show_path(PrintStream _out, int start, int end, Vector<Integer> pars, int[] ds) throws Exception
    {
        if(end >= ds.length || ds[end] == Integer.MAX_VALUE)
            return;
        _out.println("road cost: " + ds[end]);
        _out.print("path: ");

        Vector<Integer> ps = new Vector<Integer>();
        for(int i = end; i != start; i = pars.get(i)) // сut path
            ps.add(i);

        ps.add(start);

        for(int i = ps.size() - 1; i >= 0; --i)
            _out.print(ps.get(i) + "  ");

        _out.println();
        ps.clear();
        ps = null;
    }
}

class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        // Variable initialization

        int k =0;
        String s ;
        String split ;
        System.out.println("Enter number of cities: ");
        s = scanner.nextLine();
        k = Integer.parseInt(s);

        String[] names = new String[k+2];
        for (int i=1; i<=k; i++)
        {
            System.out.printf("Enter the name of the city № %s): ", i);
            names[i] = scanner.nextLine();
        }

        while (true)
        {
            System.out.println("Enter the numbers of the associated cities and the cost of moving (1 2 300), if you want to finish - enter 0: ");
            split = scanner.nextLine();
            if (split.length() != 1)
                s+= " \n "+split;
            else break;
        }
        System.out.print("The path between which cities are we looking for? (2 (enter) 3 (enter)): ");

        int start = scanner.nextInt(); //A
        scanner.nextLine();
        int end   = scanner.nextInt(); //B
        scanner.nextLine();
        int[][] mat = quictest.parse(s);

        Vector<Integer> pars = new Vector<Integer>();
        int[] ds = quictest.find(mat, start, pars);

        quictest.show_path(System.out, start, end, pars, ds);

    }
}