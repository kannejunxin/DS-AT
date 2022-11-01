package class01;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Moment_Sky
 * Date: 2022-10-30
 * Time: 下午9:59
 */
public class Code04_SelectionSort {

    public static void selectSort(int[] arr){
        //先处理边界条件
        if(arr == null || arr.length<2){
            return;
        }
        int N = arr.length;
        // 先从0~n-1选一个最小放在0 ；然后从1~n-1选一个最小放在1 ；·····
        for(int i = 0;i < N;i++){
            int minValueIndex = i; //最小值的下标  i是arr最左边的位置
            for(int j = i+1 ; j < N;j++){
                minValueIndex = arr[minValueIndex] > arr[j] ? j : minValueIndex;
            }
            swap(arr,i,minValueIndex);//交换数组中两数
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
        selectSort(arr);
        printArray(arr);
    }
}
