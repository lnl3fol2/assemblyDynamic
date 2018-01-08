package dynamicprogramming;

import java.util.Scanner;

public class TwoLine {
    int[][] a, t, least, swap;
    int n, e[], x[];

    public TwoLine() {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        
        a = new int[2][n];
        t = new int[2][n-1];
        least = new int[2][n];
        swap = new int[2][n];
        
        e = new int[2];
        x = new int[2];
        e[0] = in.nextInt();
        e[1] = in.nextInt();
        x[0] = in.nextInt();
        x[1] = in.nextInt();
        
        for(int i=0; i<n; i++)
            a[0][i] = in.nextInt();
        for(int i=0; i<n; i++)
            a[1][i] = in.nextInt();;
        for(int i=0; i<n-1; i++)
            t[0][i] = in.nextInt();
        for(int i=0; i<n-1; i++)
            t[1][i] = in.nextInt();
        
    }
    
    public void printTable(int k[][], int l){
        for(int i = 0; i<2; i++){
            for(int j = 0; j<l; j++)
                System.out.print(k[i][j]+", ");
            System.out.println("--");
        }
        System.out.println("-end-");
    }
    
    public void printTransverse(){
        int one = least[0][0], two = least[1][0];
        int cur = (one < two)? 0 : 1;
        System.out.print(cur+1+" ");
        for(int i = 1; i<n; i++){
            cur = (least[cur][i-1]-least[cur][i] == a[cur][i-1])? cur : (cur-1<0)? 1 : 0;
            System.out.print((cur+1)+" ");
        }
        System.out.println();
    }
    
    int minPath(){
        least[0][n-1] = a[0][n-1]+x[0];
        least[1][n-1] = a[1][n-1]+x[1];
        for(int i = n-2; i>=0; i--){
            least[0][i] = a[0][i] + Math.min(least[0][i+1],least[1][i+1]+t[0][i]);
            least[1][i] = a[1][i] + Math.min(least[1][i+1],least[0][i+1]+t[1][i]);
        }
        least[0][0] += e[0];
        least[1][0] += e[1];
        return Math.min(least[0][0], least[1][0]);
    }
    
}
