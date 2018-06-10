import java.util.Scanner;

//尚未知道结果咋样
public class CodeM4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int n = in.nextInt();
            int m = in.nextInt();
            int k = in.nextInt();
            int C = in.nextInt();
            int w[] = new int[m];
            double ww[] = new double[m];
            double sum = 0;
            int score[][] = new int[n][m];
            int max[] = new int[m];
            double totalscore[] = new double[n];
            double sortscore[] = new double[n];
            int result[] = new int[n];
            double mark = 0;
            int mark_i = 0;
            int mark_j = 0;
            for(int i=0;i<m;i++){
                w[i] = in.nextInt();
                sum += w[i];
                max[i] = 0;
            }
            for(int i=0;i<m;i++){
                ww[i] = w[i]*1.0/sum;
            }
            for(int i=0;i<n;i++){
                totalscore[i] = 0;
                for(int j=0;j<m;j++){
                    score[i][j] = in.nextInt();
                    if(score[i][j]==-1){
                        mark_i = i ;
                        mark_j = j;
                        score[i][j] = 0;
                    }
                    if(score[i][j]>max[j]){
                        max[j] = score[i][j];
                    }
                }
            }
            if(max[mark_j]<C){
                max[mark_j] = C;
            }
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    if(max[j]==0){
                        max[j]=1;
                    }
                    totalscore[i] += score[i][j]*1.0/max[j]*ww[j];
                    sortscore[i] = totalscore[i];
                }
            }
            qSort(sortscore, 0, sortscore.length-1);
            for(int i=0;i<n;i++){
                System.out.print(sortscore[i]+ " ");
            }
            System.out.println();
            for(int i=0;i<n;i++){
                System.out.print(totalscore[i]+ " ");
            }
            System.out.println();
            for(int i=0;i<n;i++){
                if(totalscore[i]>sortscore[k]){
                    result[i] = 1;
                }else if(totalscore[i]<sortscore[k]){
                    result[i] = 3;
                }else {
                    if(k<n-1){
                        if(sortscore[k] == sortscore[k+1]){
                            result[i] = 2;
                        }else{
                            result[i] = 1;
                        }
                    }else {
                        result[i] = 1;
                    }
                }
            }
            if((totalscore[mark_i]<sortscore[k])&&(totalscore[mark_i]+score[mark_i][mark_j]*1.0/max[mark_j]*ww[mark_j])>=sortscore[k]){
                result[mark_i] = 2;
            }
            for(int i=0;i<n;i++){
                System.out.println(result[i]);
            }
        }
    }
    public static void qSort(double a[], int p, int r){
        int q ;
        if(p<r){
            q= partition(a,p,r);
            partition(a,p,q-1);
            partition(a,q+1,r);
        }
    }
    public static int partition(double a[], int p, int r){
        double x = a[r];
        int j = p-1;
        int i;
        for(i=p;i<r;i++){
            if(a[i]<x){
                j++;
                swap(a,i,j);
            }
        }
        swap(a,r,j+1);
        return j+1;
    }
    public static void swap(double a[], int m, int n){
        double temp = a[m];
        a[m] = a[n];
        a[n]=temp;
    }
}
