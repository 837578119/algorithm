package algorithm_practice;

public class Fib {
    public static int n = 40;
    public static int [] a = new int[n+1];
    public static int num = 0;
    //斐波那契数列
    public static int fib(int n){
        num ++;
        if(n == 0){
            return 0;
        }else if(n == 1){
            return 1;
        }
        return fib(n-1) + fib(n-2);
    }
    //斐波那契数列，记忆化搜索，优化重复计算
    public static int fib2(int n){
        num ++;
        if(n == 0){
            return 0;
        }else if(n == 1){
            return 1;
        }
        if(a[n] == -1){
            a[n] = fib2(n-1) + fib2(n-2);
        }
        return a[n];
    }
    //斐波那契数列，动态规划计算
    public static int fib3(int n){
        int count;
        a[0] = 0;
        a[1] = 1;
        for(int i=2;i<=n;i++){
            a[i] = a[i-1] + a[i-2];
        }
        return a[n];
    }

    public static void main(String[] args) {

        for(int i=0;i<=n;i++){
            a[i] = -1;
        }
        System.out.println("fib1: "+ fib(n));
        System.out.println("num: " + num);
        num=0;
        System.out.println("fib2: "+ fib2(n));
        System.out.println("num: " + num);
        num=0;
        System.out.println("fib3: "+ fib3(n));
    }
}
