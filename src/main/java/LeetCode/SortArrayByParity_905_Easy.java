package LeetCode;

import java.util.Arrays;

/**
 * 输入：一个数组(非负整数)
 * 输出：按照奇偶数排好序
 * 思路：首先对数组整体排序，然后遍历两遍已经排好顺序的数组。
 *       第一遍把奇数存一波，第二遍把偶数存一波，即可。
 * 学习：看了下别人代码，发现题意tmd理解错了，wc
 *       只是奇数偶数分开就好，偶数在前奇数在后，奇书偶数可以无序
 *       我的解法算是用空间换时间吧，有的人空间复杂度为O(1)，直接在
 *       原数组上进行操作，遍历数组，遇到奇数挪到后面。
 */
public class SortArrayByParity_905_Easy {
    public static int sorted[] ;
    public static int[] sortArrayByParity(int[] A) {
        int k = 0 ;
        sorted = new int[A.length] ;
//        Arrays.sort(A);
        for(int i=0;i<A.length;i++){
            if(A[i]%2 == 0){
                sorted[k] = A[i] ;
                k ++;
            }
        }
        for(int i=0;i<A.length;i++){
            if(A[i]%2 != 0){
                sorted[k] = A[i] ;
                k ++;
            }
            if(k == A.length){
                break ;
            }
        }
        return  sorted ;
    }

    public static void main(String[] args) {
        int a[] = {4,3,2,7,8,1} ;
        int s[] = sortArrayByParity(a) ;
        System.out.println(Arrays.toString(s));
    }
}
