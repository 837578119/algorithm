import java.util.Arrays;

public class KnapSack {
    public static void main(String[] args) {
        int price[] = {6,3,5,4,6};
        int weight[] = {2,2,6,5,4};
        System.out.println(knapSack(price,weight,10));
    }

    public static int knapSack(int price[], int weight[], int knapsackWeight){
        int row = weight.length + 1;
        int col = knapsackWeight + 1;
        int result[][] = new int[row][col];
        for(int i=0;i<row;i++){
            result[i][0] = 0;
        }
        for(int i=0;i<col;i++){
            result[0][i] = 0;
        }
        for(int i=1;i<row;i++){
            for(int j=1;j<col;j++){
                result[i][j] = result[i-1][j];
                if(weight[i-1]<=j && result[i-1][j-weight[i-1]] + price[i-1] > result[i-1][j]){
                    result[i][j] = result[i-1][j-weight[i-1]] + price[i-1];
                }
                System.out.print(result[i][j]+" ");
            }
            System.out.println();
        }
//        System.out.println(Arrays.toString(result[row-1]));
        return result[row-1][col-1];
    }
}
