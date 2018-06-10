import java.util.Scanner;

public class CodeM2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            int m = in.nextInt();
            int k = in.nextInt();
            double a[] = new double[k];
            double b[] = new double[k];
            double c[] = new double[k];
            int buy[] = new int[k];
            int max = 0;
            for (int i = 0; i < k; i++) {
                a[i] = in.nextDouble();
                b[i] = in.nextDouble();
                c[i] = (m*1.0/n) * a[i] + ((n - m)*1.0/n) * b[i];
                if (c[max] <= c[i]) {
                    max = i;
                }
            }
            for(int i=0;i<k;i++){
                if(i==max){
                    buy[i] = n;
                }else{
                    buy[i] = 0;
                }
            }
            for (int i = 0; i < k; i++) {
                if(i==0){
                    if(max==i){
                        System.out.print(n);
                    }else {
                        System.out.print(0);
                    }
                }else {
                    if(max==i){
                        System.out.print(" "+n);
                    }else {
                        System.out.print(" "+0);
                    }
                }
            }
            System.out.println();
        }
    }
}
