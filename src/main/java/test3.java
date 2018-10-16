
public class test3 {

    public static void swap(int[] a, int m ,int n){
        int t ;
        t = a[m] ;
        a[m] = a[n] ;
        a[n] = t ;
    }
//    public static void permutation(int[] a, int start, int len){
//        if(start == len-1){
//            System.out.println(Arrays.toString(a));
//        }else{
//            for(int i=start;i<len;i++){
//                swap(a, start, i);
//                permutation(a, start+1, len);
//                swap(a, start, i);
//            }
//        }
//    }
    public static void main(String[] args) {
        int [] a = {1,2,3} ;
        System.out.println(1);
//        permutation(a, 0, 3);
    }
}
