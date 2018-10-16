package LeetCode;

/**
 * 输入：一个整型数组
 * 输入： true or false
 *   判断一个数组是否单调的增加或者减少
 * 思路：去重一下，然后（a[i]-a[i-1]）*（a[i+1]-a[i]）<0即为false
 */
public class MonotonicArray_896_Easy {
    public static boolean isMonotonic(int[] A) {
        int k = 0;
        int b[] = new int[50001] ;
        b[0] = A[0] ;
        for(int i=1;i<A.length;i++){
            if(A[i] != A[i-1]){
                k++;
                b[k] = A[i] ;
            }
        }
        if(b.length < 2){
            return true;
        }
        for(int i=1;i<k;i++){
            if((b[i]-b[i-1])*(b[i+1]-b[i])<0){
                return false ;
            }
        }
        return true ;
    }
    public static void main(String[] args) {
        int[]a = {1,3,2};
        System.out.println(isMonotonic(a));
    }
}
