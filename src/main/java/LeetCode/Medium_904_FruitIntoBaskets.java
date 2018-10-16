package LeetCode;

/**
 * 题目：理解题目意思，理解了半天 也是醉了
 *      就是有个数组，一排数，大小代表种类，放到俩篮子里面，但是每个篮子只能放相同的数字
 * 输入：整型数组
 * 输出：俩篮子果实数量和
 *思路：  用两个数来记录着两种水果种类，然后用max记录能放的最多的数量，count记录数量
 *         然后就是细节处理  当遇到第三种水果种类的时候，进行max count，
 *         然后计算count的初始值，还有更新记录水果种类的两个数
 */
public class Medium_904_FruitIntoBaskets {

    public static int totalFruit(int[] tree) {
        if(tree.length <= 2){
            return tree.length ;
        }
        int max = 0 ;
        int count = 2 ;
        int start = tree[0] ;
        int next = tree[1] ;
        for(int i=2;i<tree.length;i++){
            if(tree[i]==start || tree[i]==next){
                count ++ ;
            }else {
                if(start == next){
                    next = tree[i] ;
                    count ++ ;
                    continue ;
                }
                if(max < count){
                    max = count ;
                }
                start = tree[i-1] ;
                next = tree[i] ;
                count = 2 ;
                for(int j=i-2;j>=0;j--){
                    if(tree[j] == tree[i-1]){
                        count ++ ;
                    }else {
                        break ;
                    }
                }
            }
        }
        if(max < count){
            max = count ;
        }
        return max ;
    }
    public static void main(String[] args) {
        int a[] = {0,1,6,6,4,4,6} ;
        System.out.println(totalFruit(a));
    }
}
