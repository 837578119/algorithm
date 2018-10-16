package NOWCODER;

import java.util.Scanner;

public class Dapeng_A {
    public static long a[] = new long[1000010] ;
    public static long count = 0;
    public static int up = 0 ;
    public static int down = 0 ;
    public static long calc(long n){
        for(int i=0;i<n-1;i++){
            if(a[i+1] > a[i]){
                up = 1;
            }else if((a[i+1] < a[i])){
                down = 1;
            }
            if(up == 0 && down == 1){
                down = 0 ;
            }
            if(up == 1 && down == 1){
                count ++ ;
                up = 0 ;
                down = 0 ;
            }
        }
        return count ;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in) ;
        long n = in.nextLong();
        for(int i=0;i<n;i++){
            a[i] = in.nextLong() ;
        }
        System.out.println(calc(n));
    }
}
