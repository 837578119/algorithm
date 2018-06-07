import java.util.Scanner;
//AC
public class CodeM3 {
    public static double a[][] = new double[16][16];
    public static double result[] = new double[16];
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        for(int i=0;i<16;i++){
            for(int j=0;j<16;j++){
                a[i][j] = in.nextDouble();
            }
        }
        predict(a,result);
        for(int i=0;i<16;i++){
            if(i<15) {
                System.out.print(String.format("%.10f",result[i])+" ");
            }else {
                System.out.println(String.format("%.10f",result[i]));
            }
        }
    }
    public static double[] predict(double a[][], double result[]){
        for(int i=0;i<16;i++){
            result[i] = forth(a,i);
        }
        return result;
    }
    public static double first(double a[][], int key){
        double num=0;
        if(key%2==0){
            num = a[key][key+1];
        }else {
            num = a[key][key-1];
        }
        return num;
    }
    public static double second(double a[][], int key){
        double num = 0 ;
        int n;
        if(key%4 > 1){
            n = 4*(key/4);
            for(int i=0;i<=1;i++){
                num += a[key][n+i]*first(a,n+i);
            }
        }else {
            n = 4*(key/4+1);
            for(int i=1;i<=2;i++){
                num +=a[key][n-i]*first(a,n-i);
            }
        }
        num = num*first(a,key);
        return num;
    }
    public static double third(double a[][], int key){
        double num = 0;
        int n;
        if(key%8 > 3){
            n = 8*(key/8);
            for(int i=n;i<=n+3;i++){
                num += a[key][i]*second(a,i);
            }
        }else{
            n=8*(key/8+1);
            for(int i=n-1;i>=n-4;i--){
                num += a[key][i]*second(a,i);
            }
        }
        num = num * second(a,key);
        return num;
    }
    public static double forth(double a[][], int key){
        double num = 0;
        if(key>7){
            for(int i=0;i<=7;i++){
                num += a[key][i]*third(a,i);
            }
        }else {
            for(int i=8;i<=15;i++){
                num += a[key][i]*third(a,i);
            }
        }
        num = num*third(a,key);
        return num;
    }
}