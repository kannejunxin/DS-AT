package class01;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Moment_Sky
 * Date: 2022-11-01
 * Time: 下午10:59
 */
public class Code09_BSAwesome {
    public static int getLessIndex(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1; // no exist
        }
        if (arr.length == 1 || arr[0] < arr[1]) {
            return 0;  //验证arr[0]是否为局部最小
        }
        if (arr[arr.length - 1] < arr[arr.length - 2]) {
            return arr.length - 1; //验证arr[n-1]是否为局部最小
        }
        //排除了 arr[0] 、arr[n-1]为局部最小
        //证明在首是单调递减  在尾是单调递增 则中间一定存在波动，有波动就一定有局部最小
        int left = 1;
        int right = arr.length - 2;
        int mid = 0;
        while (left < right) {
            mid = (left + right) / 2;//这个可以优化写法
            if (arr[mid] > arr[mid - 1]) {
                right = mid - 1;
            } else if (arr[mid] > arr[mid + 1]) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return left;
    }
}
