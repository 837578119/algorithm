import java.lang.reflect.Array;
import java.util.Arrays;

public class HeapSort{
    public static void swap(int a[], int i, int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    public static void adjust(int a[], int i, int length){
        int temp = a[i];
        for(int k=i*2+1;k<length;k=k*2+1){
            if(k+1<length && a[k+1]>a[k]){
                k++;
            }
            if(a[k]>temp){
                a[i] = a[k];
                i = k;
            }else{
                break;
            }
        }
        a[i] = temp;
    }
    public static void sort(int a[], int length){
        //调整为大顶堆，从第一个非叶子节点开始调整
        for(int i=length/2-1;i>=0;i--){
            adjust(a,i,length);
        }
        //调整完毕后，将锥顶与最后一个元素互换位置，然后对剩下的n-1个元素调整大顶锥
        for(int j=length-1;j>0;j--){
            swap(a,0,j);
            adjust(a,0,j);
        }
    }
    public static void main(String[] args) {
        int a[] = {2,9,8,7,3,5,5,1};
        sort(a,a.length);
        System.out.println(Arrays.toString(a));
    }
}