package LeetCode;

import java.util.Scanner;

/**
 * 把n进行分割，至少分成两部分，返回最大乘积
 */
public class IntegerBreaker_343 {
    public static int a[] = new int [100] ;
    public static int max(int a, int b, int c){
        if(a<b){
            a = b;
        }
        if(a < c){
            a = c;
        }
        return a;
    }
    public static int calc2(int n){
        int num = 0;
        if(n == 1){
            return 1;
        }
        if(a[n] != -1){
            return a[n] ;
        }
        for(int i = 1;i <= n-1;i++){
            num = max(i*calc2(n-i), i*(n-i), num);
        }
        a[n] = num;
        return num;
    }
    public static int calc(int n){
        int num = 0;
        if(n == 1){
            return 1;
        }
        for(int i = 1;i <= n-1;i++){
            num = max(i*calc(n-i), i*(n-i), num);
        }
        return num;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in) ;
        int n = in.nextInt() ;
        for(int i=0;i<=n;i++){
            a[i] = -1;
        }
        int num = calc2(n) ;
        System.out.println(num);
    }
}
