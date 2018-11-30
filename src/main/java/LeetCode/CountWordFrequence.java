package LeetCode;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class CountWordFrequence {
    public void countOccur(String filepath){
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filepath));
            String line = null;
            TreeMap<String,Integer> tm = new TreeMap<String,Integer>();
            List<Character> charList = new ArrayList<Character>(Arrays.asList(',',';','.',':','?','!','\'','\"','(',')')) ;
            while((line=reader.readLine())!=null){
                line = line.toLowerCase();
                String str[] = line.split(" ");
                for(int i = 0; i<str.length; i++){
                    String word = str[i].trim();
                    char ch = word.charAt(word.length()-1) ;
                    if(charList.contains(ch)){
                        word = word.substring(0,word.length()-1) ;
                    }
                    ch = word.charAt(0) ;
                    if(charList.contains(ch)){
                        word = word.substring(1,word.length()) ;
                    }
                    if(tm.containsKey(word)){
                        tm.put(word, tm.get(word)+1);
                    }else{
                        tm.put(word, 1);
                    }
                }
            }
            for(String key : tm.keySet()){
                System.out.println(key+tm.get(key));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        CountWordFrequence count = new CountWordFrequence() ;
        String filePath = "C:\\Users\\Administrator\\Desktop\\input.txt" ;
        count.countOccur(filePath);
    }
}
