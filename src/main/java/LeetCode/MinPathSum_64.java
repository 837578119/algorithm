package LeetCode;

import java.util.Scanner;

public class MinPathSum_64 {
    public static int m = 0;
    public static int n = 0;
    public static int num = 0;
    public static int calc(int a[][]){
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i!=0&&j!=0){
                    a[i][j] += (a[i-1][j] < a[i][j-1] ? a[i-1][j] : a[i][j-1]) ;
                }
                if(i == 0 && j!=0){
                    a[i][j] += a[i][j-1];
                }
                if(i != 0 && j == 0){
                    a[i][j] += a[i-1][j];
                }
            }
        }
        return a[m-1][n-1];
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in) ;
        m = in.nextInt();
        n = in.nextInt();
        int a[][] = new int [m][n] ;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                a[i][j] = in.nextInt();
            }
        }
        System.out.println(calc(a));
    }
}
