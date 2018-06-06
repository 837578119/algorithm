import java.util.*;
import java.math.*;

public class ShellFindPrice {
    public static final int N = 1000;
    public static int len = 0;

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        String buf = "";
        while(cin.hasNext()) {
            len = cin.nextInt();
            long total[] = new long[N];
            for (int i = 0; i < len; i++) {
                buf = cin.next().toString();
               // String str[] = buf.split(".");
                String str[] = qieFen(buf,'.');
                long a = Long.parseLong(str[0].trim());
                a += judge(str[1]);
                total[i] = a;
            }
            for (int i = 0; i < len; i++) {
                System.out.println(total[i]);
            }
        }
    }
    public static String[] qieFen(String data,char str){
        String[] result = new String[2];
        char string[] = new char[data.length()];
        char string2[] = new char[1000];
        char string3[] = new char[3];
        StringBuffer buffer1 = new StringBuffer();
        StringBuffer buffer2 = new StringBuffer();
        for(int n=0;n<data.length();n++){
            string[n] = data.charAt(n);
        }
        int i=0,k=0,j=0;
        for(i=0;i<data.length()&&string[i]!=str;i++){
            j++;
            string2[i] = string[i];
        }
        for(i++;i<data.length();i++){
            string3[k] = string[i];
            k++;
        }
        for(int m=0;m<j;m++){
            buffer1.append(string2[m]);
        }
        for(int m=0;m<3;m++){
            buffer2.append(string3[m]);
        }
        result[0] = buffer1.toString();
//        System.out.println(result[0]);
        result[1] = buffer2.toString();
//        System.out.println(result[1]);
        return result;
    }
    public static int judge(String str){
//        char a[] = str.toCharArray();
        int count = 0;
        if(Integer.parseInt(str.charAt(0)+"")>=5){
            return 1;
        }
        if(Integer.parseInt(str.charAt(0)+"")<=3){
            return 0;
        }
        for(int i=str.length()-1;i>=0;i--){
            if(count+Integer.parseInt(str.charAt(i)+"")>=5){
                count = 1;
            }else {
                count = 0;
            }
        }
        return count;
    }
    public static int judge2(String str){
        int num = Integer.parseInt(str);
        for(int i=0;i<str.length();i++){
            if(num%10>=5){
                num = num/10 + 1;
            }else{
                num = num/10;
            }
        }
        if(num>=5){
            return 1;
        }
        return 0;
    }
}