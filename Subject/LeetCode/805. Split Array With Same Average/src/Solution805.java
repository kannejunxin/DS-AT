import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Moment_Sky
 * Date: 2022-11-14
 * Time: 上午8:44
 */
public class Solution805 {
    public boolean splitArraySameAverage(int[] nums) {
        int n = nums.length;
        if(n == 1) return false;
        int sum = 0;
        for(int i = 0; i<nums.length;i++){
            nums[i] *= n;
            sum += nums[i];
        }
        int avg = sum/n;
        for(int i = 0; i < n; i++){
            nums[i]-=avg;
        }
        Set<Integer> a = getSet(nums,0,n/2);
        Set<Integer> b = getSet(nums, n/2, n);
        if(a.contains(0) || b.contains(0)) return true;
        int s1 = getSum(nums,0,n/2);
        for(Integer i:a){
            if(b.contains(-i) && s1 != i)return true;
        }
        return false;

    }
    private int getSum(int []nums, int start, int end){
        int sum = 0;
        for(int i = start; i < end; i++){
            sum += nums[i];
        }
        return sum;
    }

    private Set<Integer> getSet(int[] nums, int start, int end){
        Set<Integer> ans = new HashSet<>();
        for(int i = start; i < end; i++){
            for(int pre:new HashSet<>(ans)){
                ans.add(pre+nums[i]);
            }
            ans.add(nums[i]);
        }
        return ans;
    }

}
