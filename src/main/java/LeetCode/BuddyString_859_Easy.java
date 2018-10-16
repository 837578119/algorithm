package LeetCode;

import java.util.HashMap;
import java.util.Scanner;

/**
 * 输入：两个字符串
 * 输出：如果其中一个字符串交换两个字符后，两个字符串相等，则为True
 * 思路：首先我先考虑长度，如果长度不一样或者长度为0,肯定false
 *       然后逐个比对，如果有三个不一样的字符，肯定false
 *       如果俩字符串一样，那么
 *                             如果长度大于2的情况下，有重复字符，肯定true
 *                             长度小于2的时候必须都是一样的字符才行，否则false
 * 学习：感觉我的思路有点绕，不是很清晰，学习一波别人的解法
 *       用diff来记录A，B中字符不同的个数。可以得知diff要么等于2（A,B有俩字符不相等）要么等于0（A,B相等）
 *       （1）如果 A,B有某个字符的个数不一样，返回false
 *       （2）diff = 0 时：利用字符asc码来记录每个字符出现的次数，有字符至少出现两次，返回true
 *       （3）diff = 2时：不等于2即返回false
 */
public class BuddyString_859_Easy {
    public static String A ;
    public static String B ;
    public static boolean buddyStrings(String A, String B) {
        char a[] = new char[5] ;
        char b[] = new char[5] ;
        HashMap<Character, Integer> hashMap = new HashMap<Character, Integer>() ;
        int k = 0 ;
        int mark = 0 ;
        if(A.length() != B.length() || A.length() == 0){
            return false ;
        }
        hashMap.put(A.charAt(0), 1) ;
        for(int i=1;i<A.length();i++){
            hashMap.put(A.charAt(i), 1) ;
            if(A.charAt(i) != A.charAt(i-1)){
                mark = 1 ;
            }
        }
        if(hashMap.size() < A.length()){
            mark = 2 ;
        }
        //k=0 代表这俩字符串一模一样， mark =2 代表这字符串中至少有俩字符一样
        for(int i=0;i<A.length();i++){
            if(A.charAt(i)!=B.charAt(i)){
                a[k] = A.charAt(i) ;
                b[k] = B.charAt(i) ;
                k++ ;
            }
            if(k > 2){
                return  false ;
            }
        }
        if(k == 0 && mark != 1){
            if(mark == 0){
                if(A.length() < 3){
                    return false ;
                }
            }
            return true ;
        }
        if(k != 2){
            return false ;
        }
        if(a[0] == b[1] && a[1] == b[0]){
            return true ;
        }
        return false ;
    }
    public static boolean buddyStrings2(String A, String B) {
        int a[] = new int[26] ;
        int b[] = new int[26] ;
        int diff = 0 ;
        if(A.length() != B.length() || A.length() == 0){
            return false ;
        }
        for(int i=0;i<A.length();i++){
            a[A.charAt(i)-'a'] ++ ;
            b[B.charAt(i)-'a'] ++ ;
            if(A.charAt(i) != B.charAt(i)){
                diff ++ ;
            }
        }
        for(int i=0;i<26;i++){
            if(a[i]!=b[i]){
                return false ;
            }
            if(diff == 0 && a[i] > 1){
                return true ;
            }
        }
        return diff == 2 ;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in) ;
        A = sc.next() ;
        B = sc.next() ;
        System.out.println(buddyStrings2(A, B));
    }
}
