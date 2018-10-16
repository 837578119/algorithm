package JiSuanKe;

import java.util.HashMap;
import java.util.Scanner;


//只通过了测试样例，未通过所有
public class EliminationGame {
    public static int num ;
    public static int m ;
    public static int n ;
    public static long a[] ;
    public static long d[] ;
    public static int count[] ;
    public static int q[][] ;
    public static int s[] ;
    public static HashMap<Long, Boolean> mp ;
    //用来判断区间[i,j]能不能消掉
    public static int dfs(int i, int j){
        if(q[i][j]>=0){
            return q[i][j] ;
        }
        if(i==j){
            q[i][j] = 0 ;
            return q[i][j] ;
        }
        if(i>j){
            q[i][j] = 1 ;
            return q[i][j] ;
        }
        if(i+1 == j ){
            if(mp.get(a[j]-a[i])){
                q[i][j] = 2 ;
            }else {
                q[i][j] = 0 ;
            }
            return q[i][j] ;
        }
        if(i+2 == j){
            if(((a[j]-a[j-1]) == (a[j-1] - a[i])) && mp.get(a[j]-a[j-1])){
                q[i][j] = 3 ;
            }else {
                q[i][j] = 0 ;
            }
            return q[i][j] ;
        }
        q[i][j] = 0 ;
        for(int p=i+1;p<j&& q[i][j]!=0;p++){
            if(dfs(i,p)!=0&&dfs(p+1,j)!=0){
                q[i][j] = 1 ;
            }
            if(a[j]-a[p] == a[p]-a[i] && dfs(i+1,p-1)!=0 && dfs(p+1,j-1)!=0 && mp.get(a[j]-a[p])){
                q[i][j] = 1 ;
            }
        }
        if(dfs(i+1,j-1)!=0 && mp.get(a[j]-a[i])){
            q[i][j] = 1 ;
        }
        return q[i][j] ;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in) ;
        num = sc.nextInt() ;
        count = new int[310] ;
        for(int t=0;t<num;t++){
            n = sc.nextInt() ;
            m = sc.nextInt() ;
            a = new long[310] ;
            d = new long[310] ;
            mp = new HashMap<Long, Boolean>() ;
            q = new int[310][310] ;
            s = new int[310] ;
            s[0] = 0;
            for(int i=0;i<310;i++){
                for(int j=0;j<310;j++){
                    q[i][j] = -1 ;
                }
            }
            for(int k=0;k<n;k++){
                a[k] = sc.nextLong() ;
            }
            for(int j=0;j<m;j++){
                d[j] = sc.nextLong() ;
                mp.put(d[j], true) ;
            }
            for(int i=1;i<n;i++){
                if(dfs(0,i)!=0){
                    s[i] = i + 1 ;
                    continue;
                }
                s[i] = s[i-1] ;
                for(int j=1;j<i;j++){
                    if(dfs(j,i)!=0 && s[j-1]+i-j+1>s[i]){
                        s[i] = s[j-1] + i - j + 1 ;
                    }
                }
            }
            count[t] = s[n-1] ;
        }
        for(int i=0;i<num;i++){
            System.out.println("Case "+(i+1)+": "+count[i]);
        }
    }
}
