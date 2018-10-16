package JiSuanKe;

import java.util.Scanner;

public class JumpGame {
    public static int n = 0;
    public static int calc(int a[]){
        int f[] = new int[n] ;
        f[0] = 0;
        f[1] = 1;
        for(int i=2;i<n;i++){
            f[i] = f[i-1] +1;
            for(int j=0;j<i-1;j++){
                if((j + a[j]) >= i){
                    if(f[i] > (f[j] + 1)){
                        f[i] = (f[j] + 1);
                    }
                }
            }
        }
        return f[n-1];
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in) ;
        n = in.nextInt() ;
        int a[] = new int[n] ;
        for(int i = 0;i < n;i ++){
            a[i] = in.nextInt() ;
        }
        System.out.println(calc(a));
    }
}
