import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Moment_Sky
 * Date: 2022-11-18
 * Time: 下午3:10
 */
public class Solution891 {
    public int sumSubseqWidths(int[] nums) {
        Arrays.sort(nums);
        int mod = 1000000007,n = nums.length;
        long result = 0;
        long[] pow = new long[n];//用于存放每个元素的以自己为最大值的子序列个数
        pow[0] = 1; //第一个元素以自己为最大值的子序列个数为1
        for(int i=1;i<n;i++){
            pow[i] = (pow[i-1]<<1)%mod;//<<1 相当于乘2  每一位都是存放2^i
        }
        for(int i = 0;i<n;i++){
            result = (result+(pow[i]-pow[n-i-1])*nums[i]%mod)%mod;
        }
        return (int)result;
    }
}
