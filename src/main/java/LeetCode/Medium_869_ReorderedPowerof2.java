package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * 题目：输入一个数，可以调整其各个位数，开头数字不能稳为0，看看是否能成为2的次幂
 * 输入：一个数
 * 输出：true or false
 * 思路： 把数字转化为数组，然后全排列一波，然后判断全排列中是否有满足条件的数，只要有就返回true
 *         其中判断该数是否为2次幂借鉴了别人的思路，忽略了二进制的存在 2 10/4 100/8 1000 然后你懂得 n&(n-1) == 0即是二次幂
 */
public class Medium_869_ReorderedPowerof2 {
    public static List<Integer> list = new ArrayList<Integer>() ;
    public static void permutation(int num[], int start, int len){
        if(start == len-1){
            if(num[0] == 0){
                return ;
            }
            list.add(transformTonum(num, len)) ;
        }else{
            for(int i=start;i<len;i++){
                if(isSwap(num, start, i)){
                    swap(num, start, i);
                    permutation(num, start+1, len);
                    swap(num, start, i);
                }
            }
        }
    }
    public static boolean isSwap(int num[], int start, int end){
        for(int i=start;i<end;i++){
            if(num[i] == num[end]){
                return false ;
            }
        }
        return true ;
    }
    public static void swap(int num[], int start, int end){
        int t = num[start] ;
        num[start] = num[end] ;
        num[end] = t ;
    }
    public static int transformTonum(int a[], int len){
        int num = 0 ;
        for(int i=0;i<len;i++){
            num = num*10 + a[i] ;
        }
        return num ;
    }
    public static boolean reorderedPowerOf2(int N){
        if(N == 0){
            return false ;
        }
        int a[] = new int[11] ;
        int len = 0 ;
        while(N/10 != 0){
            a[len] = N%10 ;
            N = N / 10 ;
            len ++ ;
        }
        a[len] = N ;
        permutation(a, 0, len+1);
        int n ;
        for(int i=0;i<list.size();i++){
            n = list.get(i) ;
            if((n&(n-1)) == 0){
                return true ;
            }
        }
        return false ;
    }

    public static void main(String[] args) {
        int a[] = {1,2,3};
        System.out.println(reorderedPowerOf2(10));
    }
}
