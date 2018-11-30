package LeetCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Medium_898_BitwiseORsofSubarrays {
    public int s(int[] A){
        Set<Integer> set = new HashSet<Integer>() ;
        Set<Integer> last = new HashSet<Integer>() ;
        int len = A.length ;
        for(int i=0;i<len;i++){
            Set<Integer> temp = new HashSet<Integer>() ;
            temp.add(A[i]) ;
            for(int element : last){
                temp.add(A[i] | element) ;
            }
            last = temp ;
            for(int element :temp){
                set.add(element) ;
            }
        }
        return set.size() ;
    }

    public int subarrayBitwiseORs(int[] A) {
//        List<Integer> list = new ArrayList<Integer>() ;
        Set<Integer> set = new HashSet<Integer>() ;
        int sum ;
        int max = 0 ;
        for(int i=0;i<A.length;i++){
            set.add(A[i]) ;
            max = max | A[i] ;
            set.add(max) ;
        }
        for(int i=0;i<A.length;i++){
            for(int j=i+1,n=0;j<A.length;j++){
                n = n | A[j] ;
                set.add(n) ;
                if(n == max){
                    break ;
                }
            }
        }

        return set.size() ;
    }
    public static void main(String[] args) {
        int A[] = {1,2,4} ;
        Medium_898_BitwiseORsofSubarrays t = new Medium_898_BitwiseORsofSubarrays() ;
        System.out.println(t.s(A));
    }
}
