import java.util.Scanner;

public class Test {
    public static String str ;
    public static int a[] ;
    public static int calc(){
        int asc[] = new int[128] ;
        int max = 0;
        int len = str.length() ;
        int current_len = 1;
        if(len < 2){
            max = len ;
        }
        for(int i=0;i<128;i++){
            asc[i] = -1 ;
        }
        for(int i = 0;i<len;i++){
            char ch = str.charAt(i) ;
            if(i-asc[ch]<=current_len){
                current_len = i - asc[ch] ;
            }else {
                current_len ++ ;
            }
            if(max < current_len){
                max = current_len ;
            }
            asc[ch] = i ;
        }
        return max ;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in) ;
        str = sc.next() ;
        int len = calc() ;
        System.out.println(len);
    }
}