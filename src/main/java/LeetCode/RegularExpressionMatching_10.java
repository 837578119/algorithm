package LeetCode;

public class RegularExpressionMatching_10 {

    public static boolean isMatch(String s, String p){
        if(p.isEmpty()){
            return s.isEmpty();
        }
        //当长度为1或者后一个字母不是星号的时候，匹配当前字符
        if(p.length() == 1 || p.charAt(1)!='*'){
            if(s.isEmpty()){
                return false;
            }else if(p.charAt(0) != s.charAt(0)&&p.charAt(0)!='.'){
                //若当前字符不匹配，直接返回错误
                return false;
            }else{
                return isMatch(s.substring(1), p.substring(1));
            }
        }else{
            //当后一个字母为星号的时候   重点讨论一波
            if(isMatch(s, p.substring(2))){
                return true;
            }
            int i = 0 ;
            while(i<s.length()&&(p.charAt(0) == s.charAt(i)||p.charAt(0)=='.')){
                if(isMatch(s.substring(i+1), p.substring(2))){
                    return true;
                }
                i ++ ;
            }
            return false;
        }
    }
    public static void main(String[] args) {
        System.out.println(isMatch("mississippi","mis*is*ip*i"));
    }
}
