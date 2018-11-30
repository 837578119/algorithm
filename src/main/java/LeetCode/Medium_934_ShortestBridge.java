package LeetCode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 题目：在给定的二维二进制数组 A 中，存在两座岛。（岛是由四面相连的 1 形成的一个最大组。）
 现在，我们可以将 0 变为 1，以使两座岛连接起来，变成一座岛。
 返回必须翻转的 0 的最小数目。（可以保证答案至少是 1。）
 * 思路：先利用dfs找到其中的两块岛屿，将其中的一块所有的陆地标记改为2，
 * 然后将另一块岛屿中的所有陆地添加到一个队列进行bfs，对于队列中的每一个陆地判断四周方向，
 * 若遇到标记为2的陆地则代表相连了，若遇到标记为1的陆地，则继续判断，若遇到标记为0的水，
 * 则将该块标记为1并添加到队列中，代表陆地向该方向搭了一块桥，就这样不断bfs，直到其中
 * 某一块岛屿或者桥四周遇到了标记为2的陆地，即代表两座岛屿连通了，这样我们队列元素
 * 更新了几个周期即代表桥长为几。
 *
 */
public class Medium_934_ShortestBridge {
    public static void main(String[] args) {
        int A[][] = new int[][]{{0,1},{1,0}} ;
        System.out.println(shortestBridge(A));
    }
    public static int shortestBridge(int[][] A) {
        boolean found = false ;
        int createBridge = 0 ;
        Queue<int[]> queue = new LinkedList<int[]>() ;
        int [][] directions = new int[][]{{0,1},{1,0},{0,-1},{-1,0}} ;
        //dfs区分开两个小岛
        for(int i=0;i<A.length;i++){
            for(int j=0;j<A[0].length;j++){
                if(!found&&A[i][j]==1){
                    dfs(A, i, j) ;
                    found = true ;
                }
                if(found&&A[i][j]==1){
                    queue.offer(new int[]{i,j}) ;
                }
            }
        }
        //bfs建桥直两个岛屿相连接
        while(!queue.isEmpty()){
            int size = queue.size() ;
            for(int i=0;i<size;i++){
                int point[] = queue.poll() ;
                for(int[] direction :directions){
                    int x = point[0] + direction[0] ;
                    int y = point[1] + direction[1] ;
                    if(x<0||x>=A.length||y<0||y>=A[0].length||A[x][y]==1){
                        continue;
                    }else if(A[x][y] == 2){
                        return createBridge ;
                    }else{
                        A[x][y] = 1 ;
                        queue.offer(new int[]{x,y}) ;
                    }
                }
            }
            createBridge ++ ;
        }
        return 1 ;
    }

    public static void dfs(int A[][], int x, int y){
        if(x<0||x>= A.length||y<0||y>=A[0].length||A[x][y]==2||A[x][y]==0){
            return;
        }
        A[x][y] = 2 ;
        dfs(A, x+1, y) ;
        dfs(A, x-1, y) ;
        dfs(A, x, y+1) ;
        dfs(A, x, y-1) ;
    }
}
