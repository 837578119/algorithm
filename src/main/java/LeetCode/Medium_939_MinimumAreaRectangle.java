package LeetCode;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * 题目：给出一个xy平面，坐标面上有若干点，求这些点构成的最小矩形面积，要去矩形长宽分别与xy轴平行。
 * 输入：一个二维数组（点集）
 * 输出：一个整数（最小矩形面积）
 * 别人思路：用set集合把所有点储存起来，然后遍历点集，每次取俩点(x1,y1)和(x2,y2)作为矩形的对角线上你的两个点
 *          然后判断另外两个点（x1,y2）和(x2,y1)是否也在点集中。若在，则这四个点可以构成矩形，可求得面积，
 *          依次类推，求出所有矩形面积后，选择最小的即可。
 */
public class Medium_939_MinimumAreaRectangle {

    int x ;
    int y ;
    public Medium_939_MinimumAreaRectangle(int x, int  y){
        this.x = x ;
        this.y = y ;
    }

    @Override
    public boolean equals(Object object){
        return ((Medium_939_MinimumAreaRectangle)object).x==this.x && ((Medium_939_MinimumAreaRectangle)object).y == this.y ;
    }
    @Override
    public int hashCode(){
        return Objects.hash(x,y) ;
    }

    public static void main(String[] args) {
        int [][]a = new int[][]{{1,1},{1,3},{3,1},{3,3},{2,2}};
        stable s = new stable() ;
        int t = s.minAreaRect(a) ;
        System.out.println(t);
    }

}
class stable{
    Set<Medium_939_MinimumAreaRectangle> set = new HashSet<Medium_939_MinimumAreaRectangle>() ;
    int min = Integer.MAX_VALUE ;
    int area = 0 ;
    public int minAreaRect(int[][] points) {
        for(int i=0;i<points.length;i++){
            set.add(new Medium_939_MinimumAreaRectangle(points[i][0], points[i][1])) ;
        }
        for(int i=0;i<points.length;i++){
            for(int j=i+1;j<points.length;j++){
                int x1 = points[i][0] ;
                int y1 = points[i][1] ;
                int x2 = points[j][0] ;
                int y2 = points[j][1] ;
                if(x1==x2||y1==y2){
                    continue ;
                }
                Medium_939_MinimumAreaRectangle node1 = new Medium_939_MinimumAreaRectangle(x1,y2) ;
                Medium_939_MinimumAreaRectangle node2 = new Medium_939_MinimumAreaRectangle(x2,y1) ;
                if(set.contains(node1)&&set.contains(node2)){
                    area = Math.abs((x2-x1)*(y2-y1)) ;
                    if(area!=0 && min > area){
                        min = area ;
                    }
                }
            }
        }
        if(min == Integer.MAX_VALUE){
            return 0 ;
        }
        return min ;
    }
}
