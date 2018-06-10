import javafx.util.Pair;
import java.util.*;

public class Test {
    public static void main(String[] args) {
        int a[]= {1,2,3,3,3,3,4,7,8,9};
        int pos = find(a,a.length,3);
        if(pos==-1){
            System.out.println("it is a pity, no find");
        }else{
            System.out.println("position: "+(pos+1));
        }
    }
    public static int find(int a[], int length,int x){
        int l=0,r=length-1;
        int mid=0;
        while(l<=r){
            mid = (l+r)/2;
            if(a[mid]>x){
                r = mid -1;
            }else{
                l = mid+1;
            }
        }
        return r;
    }
}