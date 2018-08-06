import javafx.util.Pair;

import java.text.SimpleDateFormat;
import java.util.*;

public class Test {
    public static void main(String[] args) throws Exception{
//        int a[]= {1,2,3,3,3,3,4,7,8,9};
//        int pos = find(a,a.length,3);
//        if(pos==-1){
//            System.out.println("it is a pity, no find");
//        }else{
//            System.out.println("position: "+(pos+1));
//        }

//        if(dateToStamp("18:00:00.001")>dateToStamp("18:30:00.000")){
//            System.out.println("1");
//        }else {
//            System.out.println("0");
//        }
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
//    public static long dateToStamp(String s) throws Exception{
//        String res;
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss.sss");
//        Date date = simpleDateFormat.parse(s);
//        long ts = date.getTime();
//        res = String.valueOf(ts);
//        return ts;
//    }
}