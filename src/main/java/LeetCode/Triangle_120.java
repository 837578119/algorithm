package LeetCode;

import java.util.Scanner;

public class Triangle_120 {
    public static int n = 4;
    public static int num = 0;
    public static int a[][] = new int [n][n];
    public static int b[][] = new int [n][n];
    //方法有bug，虽然错了，但是感觉是跟随贪心的法则走的，也值得肯定一波，先留着吧
    public static int triangle_wrong(int i, int j){
        int num = a[i][j];
        while(i>0){
            if(j==0){
                num += a[i-1][j];
            }else if(j == i){
                num += a[i-1][j-1] ;
                j = j-1;
            }else{
                if(a[i-1][j] > a[i-1][j-1]){
                    j --;
                }
                num += a[i-1][j];
            }
            i--;
        }
        return num;
    }
    //递归求解
    public static int triangle(int i, int j){
        num ++;
        if(i == n-1){
            return a[i][j];
        }
        int x = triangle(i+1, j);
        int y = triangle(i+1, j+1);
        return (x<y?x:y) + a[i][j];
    }
    //记忆化搜索减少重复计算
    public static int triangle2(int i, int j){
        num ++;
        if(i == n-1){
            return a[i][j];
        }
        if(b[i][j] == -1){
            int x = triangle2(i+1, j);
            int y = triangle2(i+1, j+1);
            b[i][j] = (x<y?x:y) + a[i][j];
        }
        return b[i][j];
    }
    //动态规划
    public static int triangle3(int n){
        for(int i=n-2;i>=0;i--){
            for(int j=0;j<=i;j++){
                a[i][j] = a[i][j]+(a[i+1][j] < a[i+1][j+1] ? a[i+1][j]:a[i+1][j+1]);
            }
        }
        return a[0][0];
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        for(int i=0;i<n;i++){
            for(int j=0;j<=i;j++){
                a[i][j] = in.nextInt();
                b[i][j] = -1;
            }
        }
        int min = triangle3(4);
        System.out.println(min);
        System.out.println("num: " + num);
    }
}
