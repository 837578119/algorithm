package LeetCode;

public class Medium_873_LengthofLongestFibonacciSubsequence {
}

class Solution2 {
    public boolean judge(int a[]){
        for(int i=2;i<a.length;i++){
            if(a[i] != a[i-1] +a[i-2]){
                return false ;
            }
        }
        return true ;
    }
    public int lenLongestFibSubseq(int[] A) {
        int f[] = new int[A.length] ;
        int g[] = new int[A.length] ;
        for(int i=2;i<A.length;i++){
            for(int j=0;j<i;j++){

            }
        }

        return 0 ;
    }
}