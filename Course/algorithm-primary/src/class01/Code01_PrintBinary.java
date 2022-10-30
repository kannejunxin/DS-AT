package class01;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Moment_Sky
 * Date: 2022-10-28
 * Time: 上午12:35
 */
//位运算
public class Code01_PrintBinary {
    //该print函数作用是 打印一个数的二进制 32位信息
    public static void print(int num){
        for(int i = 31 ; i>=0 ;i--){
            System.out.print((num&(1<<i))==0?"0":"1");
        }
        System.out.println();
    }

    public static void main(String[] args){
        //底层二进制 int 32位(4字节)
//        int num = 20000701;
//        int test = 1;
//        print(num);
//        print(test);
//        print(test<<1);
//        print(test<<2);
//        print(test<<5);

//        int a = Integer.MAX_VALUE;
//        System.out.println(a);
//        print(a);
//
//        int b = -1;
//        print(b);
//
//        int c = Integer.MIN_VALUE;
//        System.out.println(c);
//        print(c);

//        int m = 854622;
//        int n = 446657;
//        print(m);
//        print(n);
//        System.out.println("=====");
//        print(m | n);
//        print(m & n);
//        print(m ^ n);

        int a = Integer.MIN_VALUE;
        print(a);
        print(a>>1);//带符号右移
        print(a>>>1);//不带符号右移

        int c = 5;
        int d = -c;
        int e = ~c+1;

        System.out.println(c);
        System.out.println(d);
        System.out.println(e);
    }

}
