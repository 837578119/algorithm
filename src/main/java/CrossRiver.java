import java.util.Scanner;

public class CrossRiver {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int n = in.nextInt();
            int t = 0;
            int a[] = new int[n];
            for(int i=0;i<n;i++){
                a[i] = in.nextInt();
            }
            t = getTime(a,a.length);
            System.out.println(t);
        }
    }
    public static int getTime(int a[], int n){
        int num = 0;
        while(n>3){
            if(a[0]*2+a[n-2]+a[n-1] < a[0]+a[1]*2+a[n-1]){
                num +=(a[0]*2+a[n-2]+a[n-1]);
            }else{
                num += (a[0]+a[1]*2+a[n-1]);
            }
            n = n - 2;
        }
        if(n==3){
            num += (a[1]+a[2]);
        }else if(n == 2){
            num += a[1];
        }else{
            num += a[0];
        }
        return num;
    }
}
