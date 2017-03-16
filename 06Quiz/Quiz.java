import java.util.*;
public class Quiz{ 

    public static ArrayList<String> combinations(String s){
        ArrayList<String> words = new ArrayList<String>();
        solve(s, words, 0, "");
        words.add("");
        Collections.sort(words);
        return words;
    }
  
    private static void solve(String s, ArrayList<String> words, int index, String current){
        if (index >= s.length()){
            return;
        }
       solve(s, words, index + 1, current + s.substring(index, index + 1));
       solve(s, words, index + 1, current);
        words.add(current + s.substring(index, index + 1));
    }

    public static void main(String[] args){
        System.out.println(combinations("abc"));
        System.out.println(combinations("acbd"));
        System.out.println(combinations("abcde"));
    }
}