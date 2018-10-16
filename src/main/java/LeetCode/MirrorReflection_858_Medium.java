package LeetCode;

/**
 * 表示这个题没看懂题目意思（english），更别提做出来了  embarrass
 * 存在一个方形空间，如上图所示，一束光从左下角射出，方形空间的四条边都会反射，
 * 在0,1,2处存在3个接收器，问，给定方形空间的边长 p 和第一次到达右边界时距离0号接收器的距离，
 * 这束光最终会落到哪个接收器上？
 *
 *   2****1
 *   *  *
 *   *  *
 *   ****0
 *
 * 输入： 边长p, 第一次投影距离底边距离q
 * 输出： 接收器的编号
 *
 * 思路： 如果没有上下两面镜子，光线会一直向上反射，这两面镜子的作用仅仅是改变了光线的走向而已。
 * 那么可以这样理解，假设没有上下两面镜子，无限延长左右两边的镜子长度，光线一直向上反射。
 * 同时，可以通过光线走过的纵向距离来判断光线是否到达接收点，如果此距离是p的奇数倍，
 * 那么光线到达上面的接收器，若此距离是p的偶数倍则光线到到下面的接收器，即接收器0。
 * 变量d记录光线与左右镜子接触的次数，同上，可根据d来判断光线到达接收器1和2。
 * 如果距离为p的奇数倍且d为奇数，则到达接收器1，若d为偶数则到达接收器2。
 */
public class MirrorReflection_858_Medium {

    public static int mirrorReflection(int p, int q) {
        int count = 1;
        int d = 1;
        while(d*q!=count*p){
            if(d*q < count*p){
                d ++ ;
            }
            if(d*q > count*p){
                count ++ ;
            }
        }
        if(count%2==0){
            return 0;
        }
        if(d%2==0){
            return 2 ;
        }
        return 1;
    }
    public static void main(String[] args) {
        System.out.println(mirrorReflection(2,1));
    }
}
