package LeetCode;

import java.util.*;

/**
 *题目：一颗二叉树，找到其中一个节点，然后找出距离这个节点一定距离的其他所有节点
 * 输入：一颗二叉树
 * 输出：节点值的集合
 * 思路：本想先求出索引，然后算出高度，根据高度找出来满足条件的节点，it is a pity 此路不通
 * 别人思路：   构建个图，然后深搜比较靠谱 have a try    pass
 *  注意：提交的时候去掉static 才成功，你可敢信
 */
public class Medium_863_AllNodesDistanceKinBinaryTree {
    int val;
    Medium_863_AllNodesDistanceKinBinaryTree left;
    Medium_863_AllNodesDistanceKinBinaryTree right;
    Medium_863_AllNodesDistanceKinBinaryTree(int x) { val = x; }
}
class Solution1 {

    public static Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>() ;
    //构建邻接表
    public static void makeNeighborList(Medium_863_AllNodesDistanceKinBinaryTree parent,  Medium_863_AllNodesDistanceKinBinaryTree child){
        if(map.containsKey(parent.val)){
            map.get(parent.val).add(child.val) ;
        }else {
            List<Integer> list = new ArrayList<Integer>() ;
            list.add(child.val) ;
            map.put(parent.val, list) ;
        }
    }
    //构建图
    public static void makeMap(Medium_863_AllNodesDistanceKinBinaryTree parent, Medium_863_AllNodesDistanceKinBinaryTree child){
        if(parent!=null&&child!=null){
            makeNeighborList(parent, child);
            makeNeighborList(child, parent);
        }
        if(child.right!=null){
            makeMap(child, child.right);
        }
        if(child.left!=null){
            makeMap(child, child.left);
        }
    }
    public static List<Integer> distanceK2(Medium_863_AllNodesDistanceKinBinaryTree root, Medium_863_AllNodesDistanceKinBinaryTree target, int K) {

        List<Integer> list = new ArrayList<Integer>() ;
        Set<Integer> set = new HashSet<Integer>() ;
        set.add(target.val) ;
        list.add(target.val) ;
        if(getHigh(root) == 1){
            if(K == 0 && root.val == target.val){
                return list ;
            }else {
                list = new ArrayList<Integer>() ;
                return list ;
            }
        }
        makeMap(null, root);
        if(map.size()==0){
            return null ;
        }
        for(int i=0;i<K;i++){
            List<Integer> temp = new ArrayList<Integer>() ;
            for(int item : list){
                for(Integer value : map.get(item)){
                    if(!set.contains(value)){
                        temp.add(value) ;
                    }
                }
            }
            set.addAll(temp) ;
            list = new ArrayList<Integer>(temp) ;
        }
        return list ;
    }
    public static List<Integer> distanceK(Medium_863_AllNodesDistanceKinBinaryTree root, Medium_863_AllNodesDistanceKinBinaryTree target, int K) {
        List<Integer> list = new ArrayList<Integer>() ;
        List<Medium_863_AllNodesDistanceKinBinaryTree> lists = new ArrayList<Medium_863_AllNodesDistanceKinBinaryTree>() ;
        List<Integer> list2  ;
        List<Medium_863_AllNodesDistanceKinBinaryTree> temp = new ArrayList<Medium_863_AllNodesDistanceKinBinaryTree>() ;
        Medium_863_AllNodesDistanceKinBinaryTree tree ;
        temp.add(root) ;
        int high = getHigh(root) ;
        int sum = (int)Math.pow(2,high) - 1 ;
        int index = 0 ;
        int flag = 0 ;
        while(temp.size()>0 && lists.size()<=sum){
            tree = temp.get(0) ;
            if(tree.val == target.val&&flag == 0){
                flag = 1 ;
            }
            if(flag == 0){
                index ++ ;
            }
            lists.add(temp.get(0)) ;
            temp.remove(0) ;
            if(tree.left == null){
                Medium_863_AllNodesDistanceKinBinaryTree left = new Medium_863_AllNodesDistanceKinBinaryTree(-1) ;
                tree.left = left ;
            }
            if(tree.right == null){
                Medium_863_AllNodesDistanceKinBinaryTree right = new Medium_863_AllNodesDistanceKinBinaryTree(-1) ;
                tree.right = right ;
            }
            temp.add(tree.left) ;
            temp.add(tree.right) ;
        }
        temp.clear() ;
        int curtHigh = currentHight(index) ;
        if(curtHigh == 1){
            list = getNodes(lists, curtHigh+K, 0) ;
            return list ;
        }
        int high_up ;
        int high_down  ;
        int position = getPosition(index, curtHigh) ;
        if(curtHigh + K <= high){
            high_down = curtHigh + K ;
            list = getNodes(lists, high_down, position) ;
        }
        if(curtHigh - K > 1){
            high_up = curtHigh -K ;
        }else if(curtHigh - K == 1){
            high_up = 1 ;
            position = 0 ;
        }else {
            high_up = K - curtHigh + 2 ;
            if(position == 1){
                position = 2 ;
            }else{
                position = 1 ;
            }
        }

        list2 = getNodes(lists, high_up, position) ;
        list.addAll(list2) ;
        return list ;
    }
    public static int getHigh(Medium_863_AllNodesDistanceKinBinaryTree root){
        if(root == null){
            return 0 ;
        }else {
            int left = getHigh(root.left);
            int right = getHigh(root.right);
            return (left > right ? left : right) + 1;
        }
    }
    public static int currentHight(int index){
        int i = 0 ;
        int p = 1 ;
        while(index+1 >= p){
            i ++ ;
            p = (int)Math.pow(2, i) ;
        }
        return i ;
    }
    public static int getPosition(int index, int curtHigh){
        if(curtHigh == 1){
            return 0 ;
        }
        int node_pre = (int)Math.pow(2, curtHigh-1) - 1 ;
        int positon = index + 1 - node_pre ;
        int node_cur = (int)Math.pow(2,curtHigh-1) ;
        if(positon<=node_cur/2){
            return 1 ;
        }else{
            return 2 ;
        }
    }
    public static List<Integer> getNodes(List<Medium_863_AllNodesDistanceKinBinaryTree> list, int high, int position){
        List<Integer> list_nodes = new ArrayList<Integer>() ;
        int begin = 0 ;
        int end = 0 ;
        int node_pre = (int)Math.pow(2, high-1) - 1 ;
        int num = (int)Math.pow(2, high-1) ;
        if(position == 0){
            begin = node_pre ;
            end = begin+num ;
        }
        if(position == 1){
            begin = node_pre ;
            end = begin + num/2 ;
        }
        if(position == 2){
            begin = node_pre + num/2;
            end = node_pre + num ;
        }
        for(int i=begin;i<end&&i<list.size();i++){
            if(list.get(i).val != -1){
                list_nodes.add(list.get(i).val) ;
            }
        }
        return list_nodes ;
    }

    public static void main(String[] args) {
//        int a[] = {3,5,1,6,2,0,8,11,12,7,4};
//        int a[] = {1};
        int a[] = {0,1,3,-1,2};
        Medium_863_AllNodesDistanceKinBinaryTree root = new Medium_863_AllNodesDistanceKinBinaryTree(a[0]);
        Medium_863_AllNodesDistanceKinBinaryTree tree = root ;
        Medium_863_AllNodesDistanceKinBinaryTree target = new Medium_863_AllNodesDistanceKinBinaryTree(1) ;
        List<Medium_863_AllNodesDistanceKinBinaryTree> list = new ArrayList<Medium_863_AllNodesDistanceKinBinaryTree>() ;
        List<Integer> result ;
        list.add(root) ;
        for(int i=0;i<a.length-1&&list.size()>0;){
            root = list.get(0) ;
            i ++ ;
            if(a[i] != -1) {
                Medium_863_AllNodesDistanceKinBinaryTree left = new Medium_863_AllNodesDistanceKinBinaryTree(a[i]);
                root.left = left;
                left.left = null ;
                left.right = null ;
                list.add(left);
            }else{
                root.left = null ;
            }
            if(i+1 < a.length) {
                i ++ ;
                if(a[i] != -1) {
                    Medium_863_AllNodesDistanceKinBinaryTree right = new Medium_863_AllNodesDistanceKinBinaryTree(a[i]);
                    root.right = right ;
                    list.add(right) ;
                    right.left = null ;
                    right.right = null ;
                }else{
                    root.right = null ;
                }
            }
            list.remove(0) ;
        }
        list.clear() ;
        result = distanceK2(tree, target, 2) ;
        System.out.println(result.size());
        for(int i=0;i<result.size();i++){
            System.out.print(result.get(i)+" ");
        }
//        list.add(tree) ;

//        while(list.size()>0){
//            root = list.get(0) ;
//            list.remove(0) ;
//            System.out.print(root.val+" ");
//            if(root.left!=null){
//                list.add(root.left) ;
//            }
//            if(root.right!=null){
//                list.add(root.right) ;
//            }
//        }
    }
}
