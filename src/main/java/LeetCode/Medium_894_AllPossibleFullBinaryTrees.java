package LeetCode;


import java.util.ArrayList;
import java.util.List;

public class Medium_894_AllPossibleFullBinaryTrees {
    int val;
    Medium_894_AllPossibleFullBinaryTrees left;
    Medium_894_AllPossibleFullBinaryTrees right;
    Medium_894_AllPossibleFullBinaryTrees(int x) { val = x; }
}
class f{
    /**
     * 题目：给出了个N，代表一棵二叉树有N个节点，求所能构成的满二叉树。
     * 别人思路：本问题可以考虑用分治递归来解决，现在考虑有个根节点，
     * 它的所有满二叉树组合为allPossibleFBT(N) ，左子树可能有的节点数目为1，2，…，i，…，N-1，
     * 同时右子树可能有的节点数目为N-1-1，N-2-1，…，N-i-1，…，1。
     * 那么我们可以分别得到左右子树的所有满二叉树的组合：allPossibleFBT（i）和allPossibleFBT（N-i-1）。
     * 然后根据根节点和所有左右子树排列组合，就可以输出节点数为N的所有满二叉树组合。
     * 参考：https://blog.csdn.net/yeshen4328/article/details/82668887
     */
    public List<Medium_894_AllPossibleFullBinaryTrees> allPossibleFBT(int N) {
        List<Medium_894_AllPossibleFullBinaryTrees> list = new ArrayList<Medium_894_AllPossibleFullBinaryTrees>() ;
        if(N == 1){
            list.add(new Medium_894_AllPossibleFullBinaryTrees(0)) ;
            return list ;
        }
        if(N%2==0){
            return null ;
        }
        for(int i=1;i<=N;i+=2){
            for(Medium_894_AllPossibleFullBinaryTrees l : allPossibleFBT(i)) {
                for (Medium_894_AllPossibleFullBinaryTrees r : allPossibleFBT(N - i - 1)) {
                    Medium_894_AllPossibleFullBinaryTrees root = new Medium_894_AllPossibleFullBinaryTrees(0) ;
                    root.left = l ;
                    root.right = r ;
                    list.add(root) ;
                }
            }
        }
        return list ;
    }
}
