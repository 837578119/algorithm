import java.math.BigInteger;
import java.util.Scanner;

public class Test2 {
    public static int str[] ;
    public static String str_demical[] ;
    public static int n ;
    public static int flag = 1;
    public static int mark = 0;
    public static int judge_1(String s){
        int k = 0;
        for(int i=0;i<5 && s.charAt(i)=='1';i++){
            k ++;
        }
        return k ;
    }
    public static int judge_2(){
        int kind ;
        for(int i =0 ;i<n;){
            kind = judge_1(str_demical[i]) ;
            if(kind == 5 || kind == 1){
                return 0 ;
            }
            if(kind == 0){
                i++;
                continue;
            }
            int j ;
            for(j=1;j<=kind-1&&i+j<n;j++){
                if(judge_1(str_demical[i+j])!=1){
                    return 0;
                }
            }
            if(j<kind-1){
                return 0;
            }
            i = i+kind;
        }
        return 1;
    }
    public static String decimalToBinary(int decimalSource){
        BigInteger bi = new BigInteger(String.valueOf(decimalSource));
        String str = bi.toString(2) ;
        if(str.length()<8){
            int len = str.length() ;
            for(int i=0;i<8-len;i++) {
                str = '0' + str;
            }
        }
        return str;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in) ;
        n = sc.nextInt() ;
        str = new int[n] ;
        str_demical = new String[n] ;
        for(int i=0;i<n;i++){
            str[i] = sc.nextInt() ;
            str_demical[i] = decimalToBinary(str[i]) ;
        }
        flag = judge_2() ;
        if(flag == 1){
            System.out.println("true");
        }else{
            System.out.println("false");
        }
    }
}
