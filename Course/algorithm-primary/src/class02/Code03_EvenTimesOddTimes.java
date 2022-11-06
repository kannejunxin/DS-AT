package class02;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Moment_Sky
 * Date: 2022-11-04
 * Time: 下午3:50
 */
public class Code03_EvenTimesOddTimes {
    //EvenTimes 偶数次
    //OddTimes  奇数次

    //arr中 只有一个数出现奇数次
    public static void printOddTimesNum1(int[] arr){
        int eor = 0;
        for(int i = 0; i < arr.length;i++){
            eor ^= arr[i];
        }
        System.out.println(eor);
    }

    //取出一个int 类型的数 最右侧的1
    public static void printrighteston(int num){
        class01.Code01_PrintBinary.print(7);
        class01.Code01_PrintBinary.print(num & ((~num) + 1));
        //等价于
        class01.Code01_PrintBinary.print(num & -num);
    }

    //arr中 只有两个数出现奇数次
    public static void printOddTimesNum2(int[] arr) {
        int eor = 0;
        for(int i = 0; i < arr.length;i++){
            eor ^= arr[i];
        }
        //此时eor = a^b  且a!=b , eor!=0
        int rightestone = eor & ((~eor)+1); //取出最右侧1
        int eor2 = 0;//也就是eor‘
        for(int i = 0; i < arr.length;i++){
            if((arr[i]&rightestone)!=0){
                eor2 ^= arr[i];
            }
        }
        System.out.println(eor2 + " " + (eor ^ eor2));
    }


    public static void main(String[] args) {
        int[] arr1 = { 3, 3, 2, 3, 1, 1, 1, 3, 1, 1, 1 };
        printOddTimesNum1(arr1);

        printrighteston(7);

        int[] arr2 = { 4, 3, 4, 2, 2, 2, 4, 1, 1, 1, 3, 3, 1, 1, 1, 4, 2, 2 };
        printOddTimesNum2(arr2);

    }




}
