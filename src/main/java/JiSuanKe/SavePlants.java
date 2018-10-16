package JiSuanKe;

import java.util.Arrays;
import java.util.Scanner;
//通过了五组，并未通过全部测试用例
public class SavePlants {
    public static int m ;
    public static int s ;
    public static int c ;
    public static int sum = 0 ;
    public static int num[] ;
    public static int differ[] ;
    public static int differ_save[] ;
    public static int data[] ;
    public static int index[] ;
    public static int k ;
    public static int calc(){
        data = new int[m-1] ;
        index = new int[m-1] ;
        differ_save = new int[c-1] ;
        differ = new int[c-1] ;
        k = 0 ;
        if(m == 1){
            return (num[c-1] - num[0] + 1) ;
        }
        for(int i=0;i<c-1;i++){
            differ[i] = num[i+1] - num[i] ;
            differ_save[i] = num[i+1] - num[i] ;
        }
        Arrays.sort(differ);
        for(int i=0;i<m-1;i++){
            data[i] = differ[c-2-i] ;
        }
        for(int i=0;i<c-1 && k<m-1;i++){
            if(k == m-1){
                break ;
            }
            for(int j=0;j<m-1;j++){
                if(differ_save[i] == data[j]){
                    data[j] = -1 ;
                    index[k] = i ;
                    k ++ ;
                    break ;
                }
            }
        }
        sum = num[index[0]] - num[0] + 1 ;
        for(int i=1;i<k;i++){
            sum  += (num[index[i]] - num[index[i-1]+1] + 1) ;
        }
        sum += num[c-1] - num[index[k-1]+1] +1;
        return sum ;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in) ;
        m = sc.nextInt() ;
        s = sc.nextInt() ;
        c = sc.nextInt() ;
        num = new int[c+1] ;
        differ = new int[c] ;
        for(int i=0;i<c;i++){
            num[i] = sc.nextInt() ;
        }
        System.out.println(calc());
    }
}
