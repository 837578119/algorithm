package LeetCode;

/**
 * 题目大意： 给出一个二维矩阵，其元素要么为1要么为0
 *            可以对其进行转化，每行或者每列 0变成1  1变成0
 *            然后每行视为一个二进制数，把每行转化为十进制 相加求和
 *            求出来最大的这个和即可
 *  输入： 一个二维数组
 *  输出： 每行转化为十进制相加后的和
 *  思路： 显然第一列都要变成1，不是1的列进行转化操作
 *         然后从第二列开始，遍历所有行，如果0的个数比1的个数多，该列进行转化
 *         最后把每行的二进制数转化为十进制 相加即可
 */
public class Medium_861_ScoreAfterFlippingMatrix {
    public static int getArraySum(int [] B){
        int sum = 0 ;
        for(int i=0;i<B.length;i++){
            if(B[i] == 1) {
                sum += Math.pow(2, B.length-i-1) ;
            }
        }
        return sum ;
    }
    public static int matrixScore(int[][] A) {
        int sum = 0 ;
        int count = 0;
        for(int i=0;i<A.length;i++){
            if(A[i][0] == 0){
                A[i][0] = 1;
                for(int j=1;j<A[i].length;j++){
                    A[i][j] = Math.abs(A[i][j]-1) ;
                }
            }
        }
        for(int j=1;j<A[0].length;j++){
            count = 0 ;
            for(int i=0;i<A.length;i++){
                if(A[i][j] == 0){
                    count ++ ;
                }
            }
            if(count > (A.length - count)){
                for(int i=0;i<A.length;i++){
                    A[i][j] = Math.abs(A[i][j]-1) ;
                }
            }
        }
        for(int i=0;i<A.length;i++){
            sum += getArraySum(A[i]) ;
        }
        return sum ;
    }
    public static void main(String[] args) {
        int a[][] = {{0,0,1,1},{1,0,1,0},{1,1,0,0}} ;
        System.out.println(matrixScore(a));
    }
}
