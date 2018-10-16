package JiSuanKe;

import java.util.Scanner;

/**
 * 思路：
 * 设sum[i][j]表示第i个数到第j个数的和；
   设f[i][j]表示第i个数到第j个数的最大和;
  方程:f[i][j] = sum[i][j] - min(f[i+1][j](取左边),f[i][j-1](取右边));
 */
public class FetchNum {
    public static int a[] ;
    public static int sum[] ;
    public static int dp[][] ;
    public static int n ;
    public static void solution(){
       for(int i=n-2;i>0;i--){
           for(int j=i;j<=n;j++){
               dp[i][j] = sum[j] - sum[i-1] - Math.min(dp[i+1][j], dp[i][j-1]) ;
           }
       }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in) ;
        n = sc.nextInt() ;
        a = new int[n+1] ;
        sum = new int[n+5] ;
        dp  = new int[n+5][n+5] ;
        for(int i=1;i<=n;i++){
            a[i] = sc.nextInt() ;
            dp[i][i] = a[i] ;
            if(i == 1){
                sum[i] = a[i] ;
            }else{
                sum[i] = sum[i-1] + a[i] ;
            }
        }
        solution();
        System.out.println(dp[1][n] +" "+(sum[n]-dp[1][n]));
    }
}
