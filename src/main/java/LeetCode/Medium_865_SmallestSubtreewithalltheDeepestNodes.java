package LeetCode;

/**
 * 题目：就是找一个节点，它能“包括”所有最深的叶节点，题目中没有提到的细节就是，
 * 如果只有一个叶节点，那么返回的是这个叶节点本身，而不是它的父节点。
 * 输入：一个根节点
 * 输出： 节点集合
 * 别人思路：比比左右子树的深度，一样高就返回两个子树的父节点，否则就返回高的那个节点
 *
 *
 */
public class Medium_865_SmallestSubtreewithalltheDeepestNodes {
    int val;
    Medium_865_SmallestSubtreewithalltheDeepestNodes left;
    Medium_865_SmallestSubtreewithalltheDeepestNodes right;
    Medium_865_SmallestSubtreewithalltheDeepestNodes(int x) { val = x; }
}
class solution{
    public Medium_865_SmallestSubtreewithalltheDeepestNodes subtreeWithAllDeepest(Medium_865_SmallestSubtreewithalltheDeepestNodes root) {
        int l = depth(root.left) ;
        int r = depth(root.right) ;
        if(l == r){
            return root ;
        }
        if(l > r){
            return subtreeWithAllDeepest(root.left) ;
        }else{
            return subtreeWithAllDeepest(root.right) ;
        }
    }
    public static int depth(Medium_865_SmallestSubtreewithalltheDeepestNodes root){
        if(root == null){
            return 0 ;
        }else{
            int l = depth(root.left) ;
            int r = depth(root.right) ;
            return l > r ? l : r + 1 ;
        }
    }
}