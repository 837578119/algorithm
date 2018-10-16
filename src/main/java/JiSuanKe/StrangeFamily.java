package JiSuanKe;

import java.util.Scanner;
//左子树种类*右子树种类
//dp[i][j]表示i个节点不超过j代的时候，种类
public class StrangeFamily {
    public static int n ;
    public static int k ;
    public static int dp[][] = new int[210][110] ;
    public static long calc(){
        for(int i=0;i<=k;i++){
            dp[1][i] = 1 ;
        }
        for(int j=2;j<=k;j++){
            for(int i=3;i<=n;i++){
                for(int m=1;m<=i-2;m++){
                    dp[i][j] = (dp[i][j] + dp[m][j-1]*dp[i-1-m][j-1])%9901 ;
                }
            }
        }
        return (dp[n][k] - dp[n][k-1] + 9901)%9901 ;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in) ;
        n = in.nextInt() ;
        k = in.nextInt() ;
        System.out.println(calc());
    }
}
