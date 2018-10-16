package JiSuanKe;

import java.util.Scanner;
//从右下角向左上角去寻找，dp[i][j]来记录ij为左上角的正方形的最大边长
public class CalcSquare {
    public static int n ;
    public static String[] str;
    public static int dp[][] ;//dp[i][j]表示以i,j为左上角的正方形的最大边长
    public static int count[] ;
    public static void calc(){
        for(int i=n-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                if(str[i].charAt(j) - '0' != 0){
                    dp[i][j] = Math.min(dp[i][j+1], Math.min(dp[i+1][j], dp[i+1][j+1])) +1 ;
                }
                for(int k=2;k<=dp[i][j];k++){
                    count[k] ++ ;
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        str = new String[n + 1];
        dp = new int[n+1][n+1] ;
        count = new int[n+1] ;
        for (int i = 0; i < n; i++) {
            str[i] = sc.next();
            count[i] = 0;
//            for(int j=0;j<n;j++){
//                dp[i][j] = 0 ;
//            }
        }
        calc();
        for(int i=2;i<count.length;i++){
            if(count[i] == 0)
                continue;
            System.out.print(i+" "+count[i]+"\n");
        }
    }
}
