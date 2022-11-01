package class01;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Moment_Sky
 * Date: 2022-10-30
 * Time: 下午9:56
 */
public class Code03_BubbleSort {
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
    public static void main(String[] args){
        int[] arr = {7,1,8,4,5,6,9,6,3,2,10};
        printArray(arr);
        bubbleSort(arr);
        printArray(arr);
    }
}
