package JiSuanKe;

import java.util.Scanner;

public class Skiresort {
    public static int a[][] ;
    public static int edge[][] ;
    public static int r ;
    public static int c ;
    public static int Dfs(int i, int j){
        int x=0,y=0,max = 0,t;
        if(edge[i][j] != 0){
            return edge[i][j] ;
        }
        for(int m=0;m<4;m++){
            switch (m){
                case 0: x=i-1;y=j;break;
                case 1: x=i+1;y=j;break;
                case 2: x=i;y=j+1;break;
                case 3: x=i;y=j-1;break;
            }
            if(x>=0&&x<r&&y>=0&&y<c&&a[i][j]>a[x][y]){
                t = Dfs(x,y);
                if(max<t){
                    max = t ;
                }
            }
        }
        edge[i][j] = max + 1;
        return max + 1 ;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in) ;
        r = sc.nextInt() ;
        c = sc.nextInt() ;
        a = new int[r+1][c+1] ;
        edge = new int[r+1][c+1] ;
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                edge[i][j] = 0 ;
                a[i][j] = sc.nextInt() ;
            }
        }
        int max = 0;
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                edge[i][j] = Dfs(i,j) ;
                if(max<edge[i][j]){
                    max = edge[i][j] ;
                }
            }
        }
        System.out.println(max);
    }
}
