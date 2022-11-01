package class01;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Moment_Sky
 * Date: 2022-10-31
 * Time: 上午10:59
 */
public class Code05_InsertSort {
    public static void insertSort(int[] arr){
        if (arr == null || arr.length < 2) {
            return;
        }
        //先从0~0(已完成)有序,然后0~1有序,0~2有序, ..... ,0~N有序
        int N = arr.length;
        for(int end = 1;end<N;end++){
            int newValueIndex = end;//newValueIndex新来的数字
            //当我左边有数 且 左边的数比我新来的数大 为真  可以改成for循环
            while (newValueIndex-1>=0 && arr[newValueIndex - 1] > arr[newValueIndex]){
                swap(arr,newValueIndex,newValueIndex-1);
                newValueIndex--;
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
    public static void main(String[] args){
        int[] arr = {7,1,8,4,5,6,9,6,3,2,10};
        printArray(arr);
        insertSort(arr);
        printArray(arr);
    }
}
