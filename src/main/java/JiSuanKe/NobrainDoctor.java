package JiSuanKe;

import java.util.Scanner;
//考虑六种情况，互相倒水

public class NobrainDoctor {
//    public static int a, b , c;
    public static int A, B, C ;
    public static int dp[][] = new int[21][21];
//    public static int flag[][] = new int[21][21] ;
    public static void Dfs(int a, int b, int c){
        dp[a][b] = 1 ;
        if(a<A){
            if(c>=A-a&&dp[A][b] == 0){
                Dfs(A,b,c-(A-a));
            }
            if(c<A-a&&dp[a+c][b] == 0){
                Dfs(a+c,b,0);
            }
            if(b>=A-a&&dp[A][b-(A-a)] == 0){
                Dfs(A,b-(A-a),c);
            }
            if(b<A-a&&dp[a+b][0] == 0){
                Dfs(a+b,0,c);
            }
        }
        if(b<B){
            if(c>=B-b&&dp[a][B] == 0){
                Dfs(a,B,c-(B-b));
            }
            if(c<B-b&&dp[a][b+c] == 0){
                Dfs(a,b+c,0);
            }
            if(a>=B-b&&dp[a-(B-b)][B] == 0){
                Dfs(a-(B-b),B,c);
            }
            if(a<B-b&&dp[0][a+b] == 0){
                Dfs(0,a+b,c);
            }
        }
        if(c<C){
            if(a>=C-c&&dp[a-(C-c)][b]==0){
                Dfs(a-(C-c),b,C);
            }
            if(a<C-c&&dp[0][b] == 0){
                Dfs(0,b,a+c);
            }
            if(b>=C-c&&dp[a][b-(C-c)] == 0){
                Dfs(a,b-(C-c),C);
            }
            if(b<C-c&&dp[a][0] == 0){
                Dfs(a,0,b+c);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in) ;
        A = sc.nextInt() ;
        B = sc.nextInt() ;
        C = sc.nextInt() ;
        for(int i=0;i<21;i++){
            for(int j=0;j<21;j++){
                dp[i][j] = 0 ;
            }
        }
        Dfs(0, 0, C);
        int mark = 0;
        for(int i=B;i>=0;i--){
            if(dp[0][i] == 1){
                if(mark == 0){
                    System.out.print((C-i));
                    mark = 1 ;
                }else {
                    System.out.print(" " + (C-i));
                }

            }
        }
        System.out.println();
    }
}
