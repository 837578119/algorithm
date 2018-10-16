package TheBeautyOfCode;

import java.util.Arrays;

public class Recursion {
    //无重复数字的全排列
    public static void permutation(int a[], int start, int len){
        if(start == len-1){
            System.out.println(Arrays.toString(a));
        }else{
            for(int i=start;i<len;i++){
                swap(a, start, i);
                permutation(a, start+1, len);
                swap(a, start, i);
            }
        }
    }
    //有重复数字的全排列
    public static void permutation2(int a[], int start, int len){
        if(start == len-1){
            System.out.println(Arrays.toString(a));
        }else{
            for(int i=start;i<len;i++){
                if(isSwap(a, start, i)) {
                    swap(a, start, i);
                    permutation2(a, start + 1, len);
                    swap(a, start, i);
                }
            }
        }
    }
    public static void swap(int a[], int m, int n){
        if(m < 0 || m > a.length || n < 0 || n > a.length){
            System.out.println("It is a pity.");
            return ;
        }
        int temp = a[m] ;
        a[m] = a[n] ;
        a[n] = temp ;
    }
    //去重的全排列就是从第一个数字起每个数分别与它后面非重复出现的数字交换
    public static boolean isSwap(int a[], int m, int n){
        if(m < 0 || m > a.length || n < 0 || n > a.length){
            System.out.println("It is a pity.");
            return false;
        }
        for(int i=m;i<n;i++){
            if(a[i] == a[n]){
                return false ;
            }
        }
        return true ;
    }
    public static void main(String[] args) {
        int a[] = {1,1,1} ;
        permutation2(a, 0, 3);
    }
}
