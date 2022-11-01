package class01;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Moment_Sky
 * Date: 2022-11-01
 * Time: 下午10:28
 */
public class Code07_BSExit {
    //用二分法在有序数组中找到某数
    public static boolean exist(int[] sortedArr, int num){
        if(sortedArr == null || sortedArr.length == 0){
            return  false;
        }
        int L = 0;
        int R = sortedArr.length -1;
        int mid = 0;
        while (L < R){//L..R 至少两个数的时候
            mid = L + ((R-L)>>1); //这个表示等价于等于(L+R)/2   其中(R-L)>>1 = (R-L)/2
            if(sortedArr[mid] == num){
                return true;
            }else if(sortedArr[mid]>num){
                R = mid - 1;
            }else {
                L = mid +1;
            }
        }
        return sortedArr[L] == num;
    }

    // ===往下为对数器
    public static boolean test(int[] sortedArr, int num) {
        for(int cur : sortedArr) {
            if(cur == num) {
                return true;
            }
        }
        return false;
    }
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return arr;
    }
    public static void main(String[] args) {
        int testTime = 500000;
        int maxSize = 10;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr = generateRandomArray(maxSize, maxValue);
            Arrays.sort(arr);
            int value = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
            if (test(arr, value) != exist(arr, value)) {
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");
    }
}
