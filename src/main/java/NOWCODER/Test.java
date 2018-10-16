package NOWCODER;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 题目：求从左上角到右下角的距离最大的路径
 * 输入：一个二维数组
 * 输出：打印出距离最大的路径
 *
 * 思路： 从左上角向右下角行进，其实只需要考虑向下走还是向右走。
 *        所以不妨先求出来最大的路径，每走一步就把上一步的最大距离和
 *        这个单元格的数相加（上一步的最大距离无非是左面或者上面的
 *        单元格中的数，取两者的较大值即可），然后存储到这个单元格中，
 *        作为从左上角走到该单元格的距离，这样累加下去，最后右下角单元格的数就是
 *        左上角走到右下角的最大距离。
 *
 *        求出最大距离后，在倒退回去，记录下来路径。
 */
public class Test {
    public static int m;
    public static int n ;
    public static int a[][] ;
    public static List<Integer> list = new ArrayList<Integer>() ;
    public static void calc(){
//        list.add(a[n-1][m-1]) ;
        int max ;
        //初始化 如果就一行，只能从左到右或者从上到下走
        for(int i=1;i<n;i++){
            a[i][0] += a[i-1][0] ;
        }
        for(int j=1;j<m;j++){
            a[0][j] += a[0][j-1] ;
        }
        //记录左上角单元格到每个单元格的路径
        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                //选择上一步中距离的最大值
                a[i][j] += Math.max(a[i-1][j], a[i][j-1]) ;
            }
        }
        int i=n-1;
        int j = m-1;
        while(i>0&&j>0){
            max = a[i][j] - Math.max(a[i-1][j], a[i][j-1]) ;
            list.add(max);
            if(a[i-1][j]>a[i][j-1]){
                i -- ;
            }else{
                j -- ;
            }
        }
        if(i!=0){
            for(int k=i;k>0;k--){
                max = a[k][j] - a[k-1][j] ;
                list.add(max);
            }
        }
        if(j!=0){
            for(int k=j;k>0;k--){
                max = a[i][k] - a[i][k-1] ;
                list.add(max);
            }
        }
        list.add(a[0][0]);
        for(i=list.size()-1;i>=0;i--){
            if(i!=0){
                System.out.print(list.get(i)+",");
            }else{
                System.out.println(list.get(i));
            }
        }
        System.out.println(a[n-1][m-1]);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in) ;
        n = in.nextInt();
        m = in.nextInt();
        a = new int[n+1][m+1] ;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                a[i][j] = in.nextInt() ;
            }
        }
        calc();
    }
}
