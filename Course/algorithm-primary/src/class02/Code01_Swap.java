package class02;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Moment_Sky
 * Date: 2022-11-04
 * Time: 上午1:00
 */
public class Code01_Swap {
    public static void main(String[] args) {
        // a b 交换
        int a = 0,b = 2;
        System.out.println(a+" "+b);
        a = a^b;
        b = a^b;
        a = a^b;
        System.out.println(a+" "+b);

        //错误示范
        int[] arr = {3,1,100};
        int i = 0;
        int j = 0;
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
        System.out.println(arr[i] + " , " + arr[j]);
    }
}
