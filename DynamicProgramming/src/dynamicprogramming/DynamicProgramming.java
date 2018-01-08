package dynamicprogramming;
import java.util.Scanner;
public class DynamicProgramming {
    
    static int[][] a, t, least, swap;
    static int n, e[], x[];
    public static void main(String[] args) {
        
//        TwoLine line = new TwoLine();
//        line.printTable(line.a,line.n);
//        System.out.println(line.minPath());
//        line.printTransverse();
//        line.printTable(line.least, line.n);

    ThreeLine line = new ThreeLine();
//    line.printTable(line.a, 3, line.n);
    System.out.println(line.minPath());
    line.printTransverse();
    line.printTable(line.least, line.n, 3);
        
    }
}