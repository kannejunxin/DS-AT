package class01;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Moment_Sky
 * Date: 2022-11-01
 * Time: 下午7:09
 */
public class Code06_Comparator {
    //对数器：用来比对你写的代码 和 正确代码 之间结果差异
    //这里我用对数器测试一下冒泡排序
    public static void bubbleSort(int[] arr){
        if (arr == null || arr.length < 2) {
            return;
        }
        // 先从0~n-1 结束后最大值放在n-1,然后0~n-2 结束后后第二大值放在n-2, .....
        int N = arr.length;
        for(int end = N-1;end >= 0;end--){
            //0~end搞事情
            for(int second=1;second<=end;second++){
                //0~1 ,1~2, .... ,end-1~end
                if(arr[second-1]>arr[second]){
                    swap(arr,second-1,second);
                }
            }
        }
    }
    public static void swap(int[] arr, int i, int j){
        //交换数组中两数
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void printArray(int[] arr){
        //打印arr数组
        for(int i = 0; i < arr.length;i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();//换行
    }
    //  ================================================================

    public static int[] generateRandomArray(int maxSize, int maxValue){
        //Math.random() -> 等概率返回[0,1)小数
        //Math.random() * N -> 等概率返回[0,N)小数
        //(int)Math.random() * N -> 等概率返回[0,N)整数
        int[] arr = new int[(int)((maxSize+1)*Math.random())];//创建数组arr 数组长度随机
        for(int i = 0; i<arr.length;i++){
            arr[i] = (int)((maxValue+1)*Math.random()) - (int)(maxValue*Math.random());
            //等概率返回[-N,N]整数
        }
        return arr;
    }
    public static int[] copyArray(int[] arr) {
        if (arr == null) {
            return null;
        }
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }
    public static void comparator(int[] arr) {
        Arrays.sort(arr);
    }
        public static boolean isEqual(int[] arr1, int[] arr2){
        if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
            return false;
        }
        if (arr1 == null && arr2 == null) {
            return true;
        }
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        int testTime = 50000; //测试50000次
        int maxSize = 100;//随机数组长度0~100
        int maxValue = 100;
        boolean succeed = true;
        for(int i = 0; i < testTime;i++){
            int[] arr = generateRandomArray(maxSize,maxValue);
            int[] arr1 = copyArray(arr);
            int[] arr2 = copyArray(arr);
            bubbleSort(arr1);//这是自己写的方法测试arr1
            comparator(arr2);//这是java自带的Arrays.sort方法测试arr2
            if(!isEqual(arr1,arr2)){
                //比较arr1 和 arr2 是否一样
                succeed = false;
                for(int j = 0; j<arr.length;j++){
                    System.out.print(arr[i] + " ");
                }
                System.out.println();
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");
    }
}
