public class FullPermutation {
    public static void main(String[] args) {
        int a[] = {1,2,3};
        Permutaion(a,0,3);
    }
    public static void Permutaion(int a[],int start_pos,int len){
        if(start_pos==len-1){
            for(int i=0;i<len;i++){
                System.out.print(a[i]+" ");
            }
            System.out.println();
        }else {
            for(int i=start_pos;i<len;i++){
                swap(a,i,start_pos);
                Permutaion(a,start_pos+1,len);
                swap(a,i,start_pos);
            }
        }
    }
    public static void swap(int a[],int m,int n){
        int temp;
        temp = a[m];
        a[m] = a[n];
        a[n] = temp;
    }
}
