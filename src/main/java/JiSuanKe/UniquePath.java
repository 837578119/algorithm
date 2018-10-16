package JiSuanKe;

import java.util.Scanner;

public class UniquePath {
    public static int x ;
    public static int y ;
    public static int dp[][] ;
    public static int calc(){
        for(int i=0;i<x;i++){
            for(int j=0;j<y;j++){
                if(i==0 || j == 0){
                    dp[i][j] = 1 ;
                }else{
                    dp[i][j] = dp[i-1][j] + dp[i][j-1] ;
                }
            }
        }
        return dp[x-1][y-1] ;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in) ;
        while (sc.hasNext()){
            x = sc.nextInt() ;
            y = sc.nextInt() ;
            dp = new int[x+1][y+1] ;
            System.out.println(calc());
        }

    }
}
