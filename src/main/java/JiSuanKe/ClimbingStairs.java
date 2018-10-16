package JiSuanKe;

import java.util.Scanner;

public class ClimbingStairs {
    public static int n ;
    public static int a[] = new int [51];
    public static int climb(int n){
        if(n==1){
            return 1;
        }
        if(n==2){
            return 2;
        }
        a[1] = 1;
        a[2] = 2;
        for(int i=3;i<=n;i++){
            a[i] = a[i-1]+a[i-2] ;
        }
        return a[n];
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in) ;
        n = in.nextInt();
        System.out.println(climb(n));
    }
}
