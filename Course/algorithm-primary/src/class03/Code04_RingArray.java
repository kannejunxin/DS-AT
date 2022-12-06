package class03;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Moment_Sky
 * Date: 2022-11-18
 * Time: 下午5:53
 */
public class Code04_RingArray {
    //以数组的形式实现队列
    public static class MyQueue{
        private int[] arr;
        private int end;//进入的数存放的位置
        private int begin;//即将弹出的数存放的位置
        private int size;
        private final int limit;

        public MyQueue(int limit){
            arr = new int[limit];
            end = 0;
            begin = 0;
            size = 0;
            this.limit = limit;
        }
        //压入数据
        public void push(int value){
            if(size == limit){
                throw new RuntimeException("队列溢出");
            }
            size++;
            arr[end]=value;
            end = nextIndex(end);
        }
        //弹出数据
        public int pop(){
            if(size == 0){
                throw new RuntimeException("队列为空");
            }
            size--;
            int ans = arr[begin];
            begin = nextIndex(begin);
            return ans;
        }
        // 如果现在的下标是i，返回下一个位置
        private int nextIndex(int i) {
            return i < limit - 1 ? i + 1 : 0;
        }
    }
}
