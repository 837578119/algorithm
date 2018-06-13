import java.util.ArrayList;
import java.util.List;

public class YueseLoop {
    /**
     * 约瑟环问题
     * n个人，从第start个人开始报数，数到m出局
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(loop(100,1,3));
        System.out.println("===============");
        System.out.println(loop2(100,3));
    }
    public static int loop(int n, int start, int m){
        int a[] = new int[n+1];
        for(int i=1;i<=n;i++){
            a[i] = 1;
        }
        int sum = n;
        int j=0;
        for(int i=start;sum>1;i++){
            if(i>n){
                i = 1;
            }
            if(a[i]!=0){
                j++;
            }
            if(j==m){
                j=0;
                a[i] = 0;
                System.out.print(i+" ");
                sum -- ;
                if(sum == 1){
                    break;
                }
            }
        }
        System.out.println();
        for(int i=1;i<=n;i++){
            if(a[i]==1){
                return i;
            }
        }
        return 0;
    }
    public static int loop2(int n, int m){
        int s = 1;
        for(int i=2;i<=n;i++){
            s = (s+m)%i;
            if(s==0){
                s = i;
            }
        }
        return s;
    }
    private static void countThree(int n, int start, int m) {
        List<Integer> list = new ArrayList<Integer>();

        //初始化列表
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }

        while (list.size() > 0) {
            //将前连个移入列表尾端
            for (int j = 0; j < m-1; j++) {
                list.add(list.remove(start));
            }
            //打印出列的序号
            System.out.println(list.remove(start));
        }
    }
}
