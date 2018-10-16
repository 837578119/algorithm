package JiSuanKe;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
//未解决
//未解决
public class Descendingsub {
    public static int a[];
    public static int f[];
    public static int n;
    public static int max;
    public static int same;
    public static int count = 0;
    public static HashMap<ArrayList<Integer>, Integer> list = new HashMap<ArrayList<Integer>, Integer>();

    public static void solution() {
        max = 0;
        same = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (a[j] > a[i]) {
                    if (f[i] < f[j] + 1) {
                        f[i] = f[j] + 1;
                    }
                }
            }
            if (max < f[i]) {
                max = f[i];
            }
        }
        for (int i = 0; i < n; i++) {
            count = 0;
            if (f[i] == max) {
                ArrayList<Integer> l = new ArrayList<Integer>() ;
                HashMap<Integer, Integer> h = new HashMap<Integer, Integer>() ;
                for (int j = 0; j < i; j++) {
                    if (a[i] < a[j] && max == f[j] + 1) {
                        h.put(a[j], 1) ;
                    }
                }
                h.put(a[i], 1) ;
                for(int a : h.keySet()){
                    l.add(a) ;
                }
                list.put(l, 1) ;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in) ;
        n = sc.nextInt() ;
        a = new int[n+1] ;
        f = new int[n+1] ;
        for(int i=0;i<n;i++){
            a[i] = sc.nextInt() ;
            f[i] = 1 ;
        }
        solution();
        System.out.println(max+" "+list.size());
        for(ArrayList<Integer> s:list.keySet()){
            System.out.println(s);
        }
//        HashMap<ArrayList<Integer>, Integer> list = new HashMap<ArrayList<Integer>, Integer>();
//        ArrayList<Integer> l1 = new ArrayList<Integer>();
    }
}