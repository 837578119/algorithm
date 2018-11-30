package LeetCode;


public class Medium_900_RLEIterator {
    int data[] ;
    int index = 0 ;
    public Medium_900_RLEIterator(int[] A) {
        data = A ;
    }

    public int next(int n) {
        while(n>=0&&index<data.length){
            if(n>=data[index]) {
                n -= data[index];
                index += 2 ;
                if(n == 0){
                    return data[index-1] ;
                }
            }else {
                data[index] -= n ;
                return data[index+1] ;
            }
        }
        return -1 ;
    }
    public static void main(String[] args) {
        int A[] = {3,8,0,9,2,5} ;
        int n = 0;
        Medium_900_RLEIterator obj = new Medium_900_RLEIterator(A);
        int param_1 = obj.next(2);
        System.out.println(param_1);
    }
}
