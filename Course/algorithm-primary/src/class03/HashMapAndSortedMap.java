package class03;

import java.util.HashMap;
import java.util.TreeMap;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Moment_Sky
 * Date: 2022-11-20
 * Time: 下午9:41
 */
public class HashMapAndSortedMap {
    public static  class He{
        public  int value;
        public He(int v){
            value=v;
        }
    }
    public static void main(String[] args){

        //哈希表 HashMap
        //按引用传递 = 传地址
        HashMap<Integer,String> test = new HashMap<>();
        Integer a = 19000000;
        Integer b = 19000000;
        System.out.println(a == b);//fasle 按引用传递
        System.out.println(a.equals(b));//true
        test.put(a,"我是3");
        System.out.println(test.containsKey(b));//true  对于非自定义类型即使在其他地方按引用传递的，这里按值传递

        He h1 = new He(1);
        He h2 = new He(1);
        HashMap<He,String> test2 = new HashMap<>();
        test2.put(h1,"我是h1");
        System.out.println(test2.containsKey(h2));//false 对于自定义类型一定按引用传递

        HashMap<Integer, String> map = new HashMap<>();
        map.put(1000000, "我是1000000");
        map.put(2, "我是2");
        map.put(3, "我是3");
        map.put(4, "我是4");
        map.put(5, "我是5");
        map.put(6, "我是6");
        map.put(1000000, "我是1000001");

        //有序表 TreeMap 这是一个接口名
        System.out.println("有序表测试开始");
        TreeMap<Integer, String> treeMap = new TreeMap<>();

        treeMap.put(3, "我是3");
        treeMap.put(4, "我是4");
        treeMap.put(8, "我是8");
        treeMap.put(5, "我是5");
        treeMap.put(7, "我是7");
        treeMap.put(1, "我是1");
        treeMap.put(2, "我是2");

        System.out.println(treeMap.containsKey(1));
        System.out.println(treeMap.containsKey(10));

        System.out.println(treeMap.get(4));
        System.out.println(treeMap.get(10));//返回null

        System.out.println("相比HashMap的新鲜功能");
        System.out.println(treeMap.firstKey());//得到第一个Key
        System.out.println(treeMap.lastKey());//得到最后一个Key

        // treeMap.remove(4); //不删除4 下面都返回Key=4的对应Value

        // <= 4
        System.out.println(treeMap.floorKey(4));
        // >= 4
        System.out.println(treeMap.ceilingKey(4));

        //会报错 因为He没有重写比较器
        TreeMap<He,String> HeMap = new TreeMap<>();
        HeMap.put(h1,"我是h1");
        HeMap.put(h2,"我是h2");
    }
}
