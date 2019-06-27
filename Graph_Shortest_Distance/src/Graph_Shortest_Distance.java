/*
Title: Determination of a graph shortest distance
Category: Data Structure
Author: Ryan Mokarian
Task: Find all pairs of shortest distance for the attached shown graph.
 */

import java.lang.Math;
public class Graph_Shortest_Distance {
    public static void main(String[] args) {
    int [][] A = {{0,1000,1000,1000,-1,1000},
                 {1,0,1000,2,1000,1000},
                 {1000,2,0,1000,1000,-8},
                 {-4,1000,1000,0,3,1000},
                 {1000,7,1000,1000,0,1000},
                 {1000,5,10,1000,1000,0}};

        System.out.println("Matrix representation of the vertices distance using direct edge paths:");
        System.out.println();
        System.out.println("       1,    2,    3,    4,    5,    6");
        System.out.println();

        for(int i=0; i<=A.length-1;i++)
         {
            System.out.print(" "+ (i+1)+"  ");
            for(int j=0; j<=A.length-1;j++) {
                if (A[i][j] > 500) System.out.print(" inf, ");
                else System.out.printf("%4d, ", A[i][j]);
            }
                System.out.println();
        }
        System.out.println();
        System.out.println("inf means infinity" );
        System.out.println();
        System.out.println();

        for(int k=0; k<=A.length-1;k++)
        {

            for(int i=0; i<=A.length-1;i++)
            {
                for(int j=0; j<=A.length-1;j++)
                    A[i][j] = Math.min(A[i][j], A[i][k] + A[k][j]);
            }

             if (k<A.length-1)
                 System.out.println("Matrix representation of a shorter distance by going via intermediate vertex "+(k+1)+" :");
             else
                 System.out.println("Matrix representation of the vertices with SHORTEST distance (after going via last intermediate vertex "+(k+1)+") :");
            System.out.println();
            System.out.println("       1,    2,    3,    4,    5,    6");
            System.out.println();
                for(int i=0; i<=A.length-1;i++)
                {
                    System.out.print(" "+ (i+1)+"  ");
                    for(int j=0; j<=A.length-1;j++)
                    {
                        if (k == A.length - 1 & A[i][j] > 500) System.out.print("  NP, ");
                        else if (A[i][j] > 500) System.out.print(" inf, ");
                        else System.out.printf("%4d, ", A[i][j]);
                    }
                    System.out.println();
                }
                System.out.println();
                System.out.println();
        }
        System.out.println("NP means there is no path between the respective vertices." );
    }

}
