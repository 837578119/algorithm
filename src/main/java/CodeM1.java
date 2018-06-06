import java.util.Scanner;
public class CodeM1 {
    public static int m;
    public static int n;
    public static int k;
    public static int count[] = new int[12000];
    public static int a[][] = new int[12000][2];
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {//注意while处理多个case
            n = in.nextInt();
            m = in.nextInt();
            k = in.nextInt();
            for(int i=0;i<k;i++){
                a[i][0] = in.nextInt();
                a[i][1] = in.nextInt();
            }
        }
    }
}