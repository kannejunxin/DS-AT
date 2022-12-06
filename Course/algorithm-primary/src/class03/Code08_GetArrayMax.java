package class03;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Moment_Sky
 * Date: 2022-11-19
 * Time: 下午8:27
 */
public class Code08_GetArrayMax {
    // 求arr中的最大值
    public static int getMax(int[] arr) {
        return process(arr, 0, arr.length - 1);
    }
    // arr[L..R]范围上求最大值
    public static int process(int[] arr,int L,int R) {
        // arr[L..R]范围上只有一个数，直接返回
        //这也是base case基本情况，也是递归结束的标志！！！
        if (L == R) {
            return arr[L];
        }
        // L...R 不只一个数
        // mid = (L + R) / 2
        int mid = L + ((R - L) >> 1); // 中点
        int leftMax = process(arr, L, mid);
        int rightMax = process(arr, mid + 1, R);
        return Math.max(leftMax, rightMax);
    }
}
