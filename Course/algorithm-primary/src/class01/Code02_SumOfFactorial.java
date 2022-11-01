package class01;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Moment_Sky
 * Date: 2022-10-30
 * Time: 上午11:01
 */
public class Code02_SumOfFactorial {
    public static long f1(int N){
        long ans = 0;
        for(int i = 1;i <= N;i++){
            ans += factorial(i);
        }
        return ans;
    }

    public static long f2(int N){
        long ans = 0;
        long cur = 1;
        for(int i = 1; i <= N;i++){
            cur = i*cur;
            ans += cur;
        }
        return ans;
    }

    public static long factorial(int N){
        long ans = 1;
        for(int i = 1; i <= N;i++){
            ans *= i;
        }
        return ans;
    }

    public static void main(String[] args){
        int N = 10;
        System.out.println(f1(N));
        System.out.println(f2(N));
    }


}
