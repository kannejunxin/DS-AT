/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Moment_Sky
 * Date: 2022-11-08
 * Time: 下午1:53
 */
class Solution1684 {
    public int countConsistentStrings(String allowed, String[] words) {
        int ans = words.length;
        for(int i=0;i<words.length;i++){
            for(char c:words[i].toCharArray()){
                if(!allowed.contains(String.valueOf(c))){
                    ans--;
                    break;
                }
            }
        }
        return ans;
    }
}
