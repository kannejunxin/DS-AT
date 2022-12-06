import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Moment_Sky
 * Date: 2022-11-17
 * Time: 上午11:28
 */
public class Solution792 {
    public int numMatchingSubseq(String s, String[] words) {
        Deque<String>[] d = new Deque[26];
        for(int i= 0;i<26;i++){
            d[i] = new ArrayDeque<>();
        }
        for(String w : words){
            d[w.charAt(0)-'a'].add(w);
        }
        int ans = 0;
        for (char c : s.toCharArray()) {
            Deque<String> q = d[c-'a'];
            for (int k = q.size(); k > 0; --k) {
                String t = q.pollFirst();
                if(t.length() == 1){
                    ans++;
                }else{
                    d[t.charAt(1)-'a'].add(t.substring(1));
                }
            }
        }
        return ans;
    }
}
