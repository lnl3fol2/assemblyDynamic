package dynamicprogramming;

import java.util.Scanner;

public class ThreeLine {
    int[][] a, t, least, swap;
    int n, e[], x[];

    public ThreeLine() {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        a = new int[3][n];
        t = new int[6][n-1];
        least = new int[3][n];
        swap = new int[6][n];
        
        e = new int[3];
        x = new int[3];
        e[0] = in.nextInt();
        e[1] = in.nextInt();
        e[2] = in.nextInt();
        x[0] = in.nextInt();
        x[1] = in.nextInt();
        x[2] = in.nextInt();
        
        for(int j=0; j<3; j++)
            for(int i=0; i<n; i++)
                a[j][i] = in.nextInt();
        for(int j=0; j<6; j++)
            for(int i=0; i<n-1; i++)
                t[j][i] = in.nextInt();
    }
    
    public void printTable(int k[][], int l, int m){
        for(int i = 0; i<m; i++){
            for(int j = 0; j<l; j++)
                System.out.print(k[i][j]+", ");
            System.out.println("--");
        }
        System.out.println("-end-");
    }
    
    public void printTransverse(){
        int cur = 0, min = least[0][0];
        for(int i=1; i<3; i++)
            if(least[i][0]+e[i]<cur)
                cur = i;
        System.out.print((cur+1)+" ");
        for(int i = 1; i<n; i++){
            for(int j=0; j<3; j++){
                boolean exp1 = least[cur][i-1] - least[j][i] == a[cur][i-1];
                boolean exp2 = least[cur][i-1] - t[cur*2][i-1] - least[j][i] == a[cur][i-1];
                boolean exp3 = least[cur][i-1] - t[cur*2+1][i-1] - least[j][i] == a[cur][i-1];
                if(exp1||exp2||exp3){
                    cur = j;
                    break;
                }
            }
            System.out.print((cur+1)+" ");
        }
        System.out.println();
    }
    
    int minPath(){
        least[0][n-1] = a[0][n-1]+x[0];
        least[1][n-1] = a[1][n-1]+x[1];
        least[2][n-1] = a[2][n-1]+x[2];
        for(int i = n-2; i>=0; i--){
            least[0][i] = a[0][i] + Math.min(least[0][i+1], Math.min(least[1][i+1]+t[0][i], least[2][i+1]+t[1][i]));
            least[1][i] = a[1][i] + Math.min(least[1][i+1], Math.min(least[0][i+1]+t[2][i], least[2][i+1]+t[3][i]));
            least[2][i] = a[2][i] + Math.min(least[2][i+1], Math.min(least[0][i+1]+t[4][i], least[1][i+1]+t[5][i]));
        }
        return Math.min(least[0][0]+e[0], Math.min(least[1][0]+e[1], least[2][0]+e[2]));
    }
    
}
