package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 题目： 一个字符串数组，从这个数组中找出来符合某种模式的字符串
 * 输入： 字符串数组 和 模式
 * 输出：符合模式的字符串列表
 * 思路：判断字符串和模式，如果和模式匹配就加入列表
 *       用hashmap互相作映射，映射完毕后判断长度是否一致
 *       如果不一致，直接返回false.
 *       然后根据映射表，把模式转化为字符串，判断转换后的字符串是否和字符串数组中的字符串一致即可。
 */
public class FindandReplacePattern_890_Medium {

    public static List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> list = new ArrayList<String>() ;
        for(int i=0;i<words.length;i++){
            if(judge(words[i], pattern)){
                list.add(words[i]) ;
            }
        }
        return list ;
    }
    public static boolean judge(String str, String pattern){
        HashMap<Character, Character> hashMap = new HashMap<Character, Character>() ;
        HashMap<Character, Character> hashMap_plus = new HashMap<Character, Character>() ;
        String str_plus = "";
        if(str.length()!=pattern.length()){
            return false ;
        }
        for(int i=0;i<str.length();i++){
            hashMap.put(pattern.charAt(i), str.charAt(i)) ;
            hashMap_plus.put(str.charAt(i), pattern.charAt(i)) ;
        }
        if(hashMap.size()!=hashMap_plus.size()){
            return false ;
        }
        for(int i=0;i<str.length();i++){
            if(hashMap.get(pattern.charAt(i)) == null){
                return false ;
            }
            str_plus += hashMap.get(pattern.charAt(i)) ;
        }
        return str.equals(str_plus) ;
    }

    public static void main(String[] args) {
        String[] words = {"abc","deq","mee","aqq","dkd","ccc"} ;
        String parrern = "abb";
        List<String> list = findAndReplacePattern(words, parrern) ;
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }
    }
}
