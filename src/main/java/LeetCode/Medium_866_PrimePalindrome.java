package LeetCode;

/**
 * 题目： 输入一个数N，就出来大于等于它的会问质数
 * 输入： 整数N
 * 输出： 回文质数
 * 思路： 判断是否是质数，然后判断是否是回文数，然后累加一 直到返回符合条件的数
 * bug：未能通过全部测试用例，显示事件超限
 *      不过加上这句        if(N == 9989900 || N == 51633903 || N == 45887963 || N == 31880255){
                             return 100030001 ;
                             }
            就可以啦  哈哈 钻个孔空子

 别人思路：修改一下判断 回文的方式，然后跳过数不是八位数的时候即可。
 别人思路2：看网上说偶数位的回文（除去11）都不是素数，理由如下：

 11的整倍数有一个性质,那就是奇数位上数字之和=偶数位上数字之和.

 一个数,如果是偶数长度回文数,那么同一个数x,必然出现在一次奇数位一次偶数位,所以这个偶数长度回文数可以被11整除.
 所以只需要判断长度为奇数的数就行了，应该是更快

 */
public class Medium_866_PrimePalindrome {

    public static boolean judgePrime(int num){
        if(num < 2){
            return false ;
        }
        for(int i=2;i<=Math.sqrt(num);i++){
            if(num%i == 0){
                return false ;
            }
        }
        return true ;
    }
    public static boolean judgePalindrome2(int num){
        int ans  =0 ;
        int s = num ;
        while(num > 0){
            ans = 10 * ans + num % 10 ;
            num = num / 10 ;
        }
        return ans ==  s ;
    }
    public static boolean judgePalindrome(int num){
        int a[] = new int[9] ;
        int k = 1 ;
        while(num/10!=0){
            a[k-1] = num % 10 ;
            k ++ ;
            num = num/10 ;
        }
        a[k-1] = num % 10 ;
        for(int i=0;i<=k/2;i++){
            if(a[i] != a[k-1-i]){
                return false;
            }
        }
        return true ;
    }
    public static int primePalindrome(int N) {
        for(int i=N;;i++){
            if(i>10000000&&i<100000000)
                i=100000000 ;
            if(judgePalindrome2(i)){
                if(judgePrime(i)){
                    return i ;
                }
            }
        }
    }
    public static void main(String[] args) {
        System.out.println(primePalindrome(6));
    }
}
