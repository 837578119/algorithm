import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class CodeMB1 {
    public static int max = 0;
    public static int count = 0;
    public static long time = 0;
    public static int num = 100020;
    public static int x[];
    public static int y[] = new int[num];
    public static int z[] = new int[num];
    public static long t[] = new long[num];
    public static void main(String[] args) throws Exception{
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            max=0;
            count=0;
            time=0;
            int n = in.nextInt();
            int m = in.nextInt();
            int k = in.nextInt();
            int room[][] = new int[n][m];
            for(int i=0;i<k;i++){
                x[i] = in.nextInt()-1;
                y[i] = in.nextInt()-1;
                z[i] = in.nextInt();
                t[i] = dateToStamp(in.next());
            }
            qSort(t,0,k-1);
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    room[i][j] = 0;
                }
            }
            for(int i=0;i<k;i++){
                if(z[i]==0){
                    room[x[i]][y[i]]++;
                    if(room[x[i]][y[i]]==1){
                        count++;
                    }
                }else if(z[i]==1){
                    room[x[i]][y[i]]--;
                    if( room[x[i]][y[i]]==0){
                        count -- ;
                    }
                }
                if(max<=count){
                    max = count;
                    time = t[i];
                }
            }
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    room[i][j] = 0;
                }
            }
            for(int i=0;(i<k)&&(t[i]<=time);i++){
                if (z[i] == 0) {
                    room[x[i]][y[i]]++;
                } else {
                    room[x[i]][y[i]]--;
                }
            }
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    if(room[i][j]>0){
                        System.out.print(1);
                    }else{
                        System.out.print(0);
                    }
                }
                System.out.println();
            }
        }
    }
    public static void qSort(long a[], int p, int r){
        int q ;
        if(p<r){
            q= partition(a,p,r);
            if(q>0) {
                partition(a, p, q - 1);
            }
            partition(a,q+1,r);
        }
    }
    public static int partition(long a[], int p, int r){
        long s = a[r];
        int j = p-1;
        int i;
        for(i=p;i<r;i++){
            if(a[i]<s){
                j++;
                swap(a,i,j);
                swap(x,i,j);
                swap(y,i,j);
                swap(z,i,j);
            }
        }
        swap(a,r,j+1);
        swap(x,r,j+1);
        swap(y,r,j+1);
        swap(z,r,j+1);
        return j+1;
    }
    public static void swap(long a[], int m, int n){
        long temp = a[m];
        a[m] = a[n];
        a[n]=temp;
    }
    public static void swap(int a[], int m, int n){
        int temp = a[m];
        a[m] = a[n];
        a[n]=temp;
    }
    public static long dateToStamp(String s) throws Exception{
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss.SSS");
        Date date = simpleDateFormat.parse(s);
        long ts = date.getTime();
        return ts;
    }
}
