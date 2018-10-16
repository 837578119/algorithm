package JiSuanKe;

import java.util.Scanner;
//未通过  估计递归太耗时间
public class Robot {
    public static int n ;
    public static int x ;
    public static int y ;
    public static int a[][] ;
    public static int count[] ;
    public static int sum = 0 ;
//    public static int num = 0 ;
    public static boolean isNextToEnd(int dx, int dy){
        if(dx > x || dy > y){
            return false ;
        }
        return true ;
    }
    public static boolean isNextToStart(int dx, int dy){
        if(dx<0||dy<0||a[dx][dy]==1){
            return false;
        }
        return true;
    }
    public static void toEnd(int dx, int dy){
        if(dx == x && dy == y){
            toStart(dx, dy);
            return;
        }
        if(isNextToEnd(dx,dy+1)){
            a[dx][dy+1] = 1 ;
            toEnd(dx, dy+1) ;
            a[dx][dy+1] = 0 ;
        }
        if(isNextToEnd(dx+1, dy)){
            a[dx+1][dy] = 1 ;
            toEnd(dx+1, dy) ;
            a[dx+1][dy] = 0 ;
        }
    }
    public static void toStart(int dx, int dy){
        if(dx==0&&dy==0){
            sum ++ ;
            return;
        }
        if(isNextToStart(dx,dy-1)){
            a[dx][dy-1] = 2 ;
            toStart(dx,dy-1) ;
            a[dx][dy-1] = 0 ;
        }
        if(isNextToStart(dx-1, dy)){
            a[dx-1][dy] = 2 ;
            toStart(dx-1, dy) ;
            a[dx-1][dy] = 0 ;
        }

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in) ;
        n = sc.nextInt() ;
        count = new int[n+1] ;
        for(int i=0;i<n;i++) {
            x = sc.nextInt();
            y = sc.nextInt();
            a = new int[x + 1][y + 1];
            toEnd(0, 0);
            count[i] = sum ;
            sum = 0 ;
        }
        for(int i=0;i<n;i++) {
            System.out.println(count[i]);
        }
    }

}
