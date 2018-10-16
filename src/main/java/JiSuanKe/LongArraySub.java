package JiSuanKe;

import java.util.ArrayList;
import java.util.Scanner;

//思路：比起之前的LIS，多设立个数组标记一下上个位置的坐标即可
public class LongArraySub {
    public static int n ;
    public static int a[] ;
    public static int f[] ;
    public static int pre[] = new int[1005];
    public static void calc(){
        int index_max = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                if(a[i]<a[j] && f[i]<f[j]+1){
                    f[i] = f[j] + 1 ;
                    pre[i] = j ;
                }
            }
            if(f[index_max] < f[i]){
                index_max = i ;
            }
        }
        ArrayList<Integer> list = new ArrayList<Integer>() ;
        int k = 0;
        for(int i=index_max;i>=0;){
            list.add(a[i]) ;
            i = pre[i] ;
            k++;
            if(k==f[index_max]){
                break;
            }
        }
        for(int i=list.size()-1;i>=0;i--){
            if(i!=0){
                System.out.print(list.get(i)+" ");
            }else{
                System.out.print(list.get(i)+"\n");
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in) ;
        n = sc.nextInt() ;
        a = new int[n+1] ;
        f = new int[n+1] ;
        for(int i=0;i<n;i++){
            a[i] = sc.nextInt() ;
            f[i] = 1 ;
        }
        calc() ;
    }
}
