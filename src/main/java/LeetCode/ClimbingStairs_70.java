package LeetCode;

/**
 * 有一个楼梯，总共会有n阶台阶。每一次，可以上一个台阶，也可以上两个
 * 。问，爬上这样的一个楼梯，一共有多少不同的方法。
 */
public class ClimbingStairs_70 {
    public static int n = 5;
    public static int a[] = new int[n+1];
    public static int climbStairs(int n){
        if(n==1){
            return 1;
        }else if(n==2){
            return 2;
        }else{
            return climbStairs(n-1)+climbStairs(n-2);
        }
    }
    public static int climbStairs2(int n){
        a[1] = 1;
        a[2] = 2;
        for(int i=3;i<=n;i++){
            a[i] = a[i-1]+a[i-2];
        }
        return a[n];
    }
    public static void main(String[] args) {
        for(int i=0;i<=n;i++){
            a[i] = -1;
        }
        System.out.println(climbStairs(n));
        System.out.println(climbStairs2(n));
    }
}
