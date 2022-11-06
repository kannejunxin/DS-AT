package class02;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Moment_Sky
 * Date: 2022-11-05
 * Time: 下午10:41
 */
public class Code03_KM {
    //经典解法 哈希表
    public static int hashKTimes(int[] arr,int k, int m){
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int num : arr){
            if(map.containsKey(num)){
                map.put(num,map.get(num)+1);
            }else{
                map.put(num,1);
            }
        }
        for(Map.Entry<Integer,Integer> entry: map.entrySet()){
            if(entry.getValue() == k){
                return entry.getKey();
            }
        }
        return -1;
    }

    // 请保证arr中，只有一种数出现了K次，其他数都出现了M次
    public static int onlyKTimes(int[] arr,int k, int m){
        int[] t = new int[32];
        //t[0]位置 表示int的32中第0位置出现多少次
        //t[1]位置 表示int的32中第1位置出现多少次 依此类推
        //注意这里别以为两个for循环 时间复杂度就是O(n^2)，实际上内循环就循环32次是个常数项，所以依旧还是O(n)
        for(int num : arr){
            for(int i=0;i<=31;i++){
                //t[i]+=(num>>i)&1;
                t[i]+=((num>>i)&1)==0?0:1;
            }
        }
        int ans = 0;//只出现k次的数
        for(int i=0;i<32;i++){
            if(t[i]%m != 0){ //说明这个数在第i位是1
                ans |= (1<<i);
            }
        }
        return ans;
    }

    //~~~~~~~对数器  要看懂

    //生成符合要求的随机数组
    public static int[] randomArray(int maxKinds, int range,int k,int m){
        int ktimeNum = randomNumber(range);
        // 2
        int numKinds = (int) (Math.random() * maxKinds) + 2;
        // k * 1 + (numKinds - 1) * m
        int[] arr = new int[k + (numKinds - 1) * m];
        int index = 0;
        for (; index < k; index++) {
            arr[index] = ktimeNum;
        }
        numKinds--;
        HashSet<Integer> set = new HashSet<>();
        set.add(ktimeNum);
        while (numKinds != 0) {
            int curNum = 0;
            do {
                curNum = randomNumber(range);
            } while (set.contains(curNum));
            set.add(curNum);
            numKinds--;
            for (int i = 0; i < m; i++) {
                arr[index++] = curNum;
            }
        }
        // arr 填好了
        for (int i = 0; i < arr.length; i++) {
            // i 位置的数，我想随机和j位置的数做交换
            int j = (int) (Math.random() * arr.length);// 0 ~ N-1
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }
        return arr;
    }
    //生成随机数 [-range , range]
    public static int randomNumber(int range){
        return (int)((Math.random()*range)+1) - (int)((Math.random()*range)+1);
    }

    public static void main(String[] args) {
//        int[] arr = {4,3,1,3,3,1,1,4};
//        int k = 2;
//        int m = 3;
//        System.out.println(onlyKTimes(arr,k,m));
//        System.out.println(hashKTimes(arr, k, m));
        int kind = 5;
        int range = 200;
        int testTime = 10000;//测试次数
        int max = 9;
        for(int i=0;i<testTime;i++){
            int a = (int) (Math.random() * max) + 1; // a 1 ~ 9
            int b = (int) (Math.random() * max) + 1; // b 1 ~ 9
            int k = Math.min(a, b);
            int m = Math.max(a, b);
            // k < m
            if (k == m) {
                m++;
            }
            int[] arr = randomArray(kind,range,k,m);
            int arr1 = hashKTimes(arr,k,m);
            int arr2 = onlyKTimes(arr,k,m);
            if(arr1!=arr2){
                for(int n : arr){
                    System.out.print(n + " ");
                }
                System.out.println();
                System.out.println("出错啦");
            }else{
                System.out.println("测试正确");
            }
        }
    }


}
