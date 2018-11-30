package LeetCode;

import java.util.*;

public class Medium_907SumofSubarrayMinimums {
    int sum = 0 ;
    public List<Integer> list = new ArrayList<Integer>() ;
    public List<Integer> last = new ArrayList<Integer>() ;
    public static void main(String[] args) {
        int A[] = {3,1,2,4} ;
        Medium_907SumofSubarrayMinimums t = new Medium_907SumofSubarrayMinimums() ;
        System.out.println(t.sumSubarrayMins(A));
    }

    /**
     * 题目：给定正整数数组A，求出A中所有连续子序列的最小值之和mod (10^9 + 7)。
     * 别人思路：
     */
    public int sumSubarrayMins(int[] A) {
        int sum = 0 ;
        Stack<int[]> s1 = new Stack<int[]>() ;
        Stack<int[]> s2 = new Stack<int[]>() ;
        int len = A.length ;
        int left[] = new int[len] ;
        int right[] = new int[len] ;
        for(int i=0;i<len;i++){
            int count = 1 ;
            while(!s1.empty()&&s1.peek()[0]>A[i]){
                count += s1.pop()[1] ;
            }
            s1.push(new int[]{A[i], count}) ;
            left[i] = count ;
        }
        for(int i=len-1;i>=0;i--){
            int count = 1 ;
            while(!s2.empty()&&s2.peek()[0]>=A[i]){
                count += s2.pop()[1] ;
            }
            s2.push(new int[]{A[i], count}) ;
            right[i] = count ;
        }
        for(int i=0;i<len;i++){
            sum = (sum + left[i]*right[i]*A[i])%1000000007 ;
        }
        return sum ;
    }
    public int sumSubarrayMins2(int[] A) {
        for(int i=0;i<A.length;i++){
            List<Integer> temp = new ArrayList<Integer>() ;
            temp.add(A[i]) ;
            for(int element:last){
                if(element < A[i]){
                    temp.add(element) ;
                }else{
                    temp.add(A[i]) ;
                }
            }
            last = temp ;
            for(int element:temp){
                sum+=element ;
                if(sum>1000000007){
                    sum = sum % 1000000007 ;
                }
            }
        }
        return sum ;
    }
}
