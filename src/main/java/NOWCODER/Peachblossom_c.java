package NOWCODER;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Peachblossom_c {
    public static int n = 0 ;
    public static int count = 0 ;
    public static ArrayList<ArrayList<Integer>> list= new ArrayList();
    public static int a ;
    public static int b ;
    public static boolean[] flag ;
    public static int maxDepth = 0;
    public static int index = -1 ;
    
    public static void calc(){

    }
    public static void dfs(int u, int deep){
        if(maxDepth < deep){
            maxDepth = deep ;
            index = u ;
        }
        flag[u] = true ;
        for(int i=0;i<list.get(u).size();i++){
            int v = list.get(u).get(i) ;
            if(flag[v] == false){
                dfs(v, deep + 1);
            }
        }
    }

    public static void main(String[] args) throws Exception{
//        Scanner in = new Scanner(System.in) ;
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        StreamTokenizer in = new StreamTokenizer(br);
//        n = in.nextInt() ;
        in.nextToken() ;
        n = (int)in.nval ;
        for(int i=0;i<=n;i++){
            list.add(new ArrayList<Integer>());
        }
        for(int i=0;i<n-1;i++){
            in.nextToken() ;
            a = (int)in.nval ;
            in.nextToken() ;
            b = (int)in.nval ;
            list.get(a).add(b) ;
            list.get(b).add(a) ;
        }
        flag = new boolean[n+1] ;
        dfs(1,1);
        Arrays.fill(flag, false);
        dfs(index, 1);
        System.out.println(maxDepth);
    }
}
